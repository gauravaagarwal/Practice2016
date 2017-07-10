package practice.junit;

import java.util.concurrent.atomic.AtomicInteger;

public class BlockingQueueWithNode<T> {

	private final int limit;
	private AtomicInteger size = new AtomicInteger(0);
	private Node first;
	private Node last;

	private class Node {
		T item;
		Node next;

		Node(T item) {
			this.item = item;
		}
		
		public String toString(){
			return " this->"+ item.toString() +" next->"+ next.item.toString();
		}
	}
	public String toString(){
		return first.toString() +":  :"+ last.toString()+" : size: "+size;
	}
	
	public BlockingQueueWithNode(int limit) {
		this.limit = limit;
	}

	public synchronized void enqueue(T element) {
		if (size.get() == limit) {
			try {
				wait();
			} catch (InterruptedException ex) {

			}
		}
		size.incrementAndGet();
		if (size.get() == 1) {
			notifyAll();
			first = last = new Node(element);
		} else {
			last = last.next = new Node(element);
		}
	}

	public synchronized T dequeue() {
		if (size.get() == 0) {
			try {
				wait();
			} catch (InterruptedException ex) {

			}
		}
		if (size.get() == limit) {
			notifyAll();
		}
		Node element = first;
		if (size.get() == 1) {
			first = last = null;
		} else {
			first = first.next;
		}
		size.decrementAndGet();
		return element.item;
	}

	public int getSize() {
		return size.get();
	}

}
