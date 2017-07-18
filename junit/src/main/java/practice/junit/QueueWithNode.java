package practice.junit;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author gauravaagarwal
 *
 * @param <T>
 */
public class QueueWithNode<T> implements Iterable<T> {

	private int size = 0;
	private Node<T> head;
	private Node<T> last;

	private static class Node<T> {
		T item;
		Node<T> next;

		Node(T item) {
			this.item = item;
		}
	}

	public QueueWithNode() {
		head = last = new Node<T>(null);
	}

	/**
	 * only use last
	 * 
	 * @param element
	 * @return
	 */
	public synchronized boolean enqueue(T element) {
		if (size == Integer.MAX_VALUE) {
			return false;
		}
		last = last.next = new Node<T>(element);
		size++;
		return true;
	}

	/** only use first
	 * @return
	 */
	public synchronized T dequeue() {
		if (size == 0) {
			return null;
		}
		Node<T> first = head.next;
		head.next=first.next;
		first.next=null;
		size--;
		return first.item;
	}

	public int getSize() {
		return size;
	}

	private class QueueIterator implements Iterator<T> {
		private Node<T> current;

		public QueueIterator() {
			current = head;
		}

		public boolean hasNext() {
			return current != null && current.item != null;
		}

		public T next() {
			T item = current.item;
			current = current.next;
			return item;
		}

		public void remove() {

		}

	}

	public Iterator<T> iterator() {
		return new QueueIterator();
	}

}
