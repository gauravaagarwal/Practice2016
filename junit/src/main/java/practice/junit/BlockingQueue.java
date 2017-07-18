package practice.junit;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue<T> {

	private final int limit;
	private final ReentrantLock putLock = new ReentrantLock();
	private final Condition putCondition = putLock.newCondition();
	private final ReentrantLock gettLock = new ReentrantLock();
	private final Condition getCondition = gettLock.newCondition();
	private Node<T> head;
	private Node<T> last;
	private final AtomicInteger count = new AtomicInteger(0);

	private static class Node<T> {
		T item;
		Node<T> next;

		Node(T item) {
			this.item = item;
		}
	}

	public BlockingQueue(int limit) {
		this.limit = limit;
		head = last = new Node<T>(null);// INSERT AT LAST, DELETE FROM HEAD
	}

	/**
	 * put only use last for insertion, don't use head
	 * 
	 * @param element
	 */
	public void enqueue(T element) throws InterruptedException {
		Node<T> newNode = new Node<T>(element);
		putLock.lockInterruptibly();
		try {
			while (count.get() == limit) {
				putCondition.await();
			}
			assert last.next == null;
			last.next = newNode;
			last = last.next;
			assert last.next == null;
			count.incrementAndGet();
			if (count.get() != limit)
				putCondition.signal();
		} finally {
			putLock.unlock();
		}
		if (count.get() == 1) {
			gettLock.lock();
			try {
				getCondition.signal();// notify waiting threads for first
										// insertion due to empty queue
			} finally {
				gettLock.unlock();
			}
		}
	}

	public T dequeue() throws InterruptedException {
		gettLock.lockInterruptibly();
		T element = null;
		try {
			while (count.get() == 0) {
				getCondition.await();
			}
			count.decrementAndGet();
			element = delete();

		} finally {
			if (count.get() != 0)
				getCondition.signal();
		}
		if (count.get() + 1 == limit) {
			putLock.lock();
			try {
				putCondition.signalAll();
			} finally {
				putLock.unlock();
			}
		}
		return element;
	}

	private T delete() {
		assert head.item == null;
		Node<T> first = head.next;
		head.next = first.next;
		first.next = null;
		return first.item;
	}

	public int getSize() {
		return count.get();
	}

}
