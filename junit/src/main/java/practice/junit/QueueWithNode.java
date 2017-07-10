package practice.junit;

import java.util.concurrent.atomic.AtomicInteger;

public class QueueWithNode<T> {

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
	
	public QueueWithNode() {
	}

	public synchronized boolean enqueue(T element) {
		if (size.get() == Integer.MAX_VALUE) {
			return false;
		}
		size.incrementAndGet();
		if (size.get() == 1) {
			first = last = new Node(element);
		} else {
			last = last.next = new Node(element);
		}
		return true;
	}

	public synchronized T dequeue() {
		if (size.get() == 0) {
			return null;
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
