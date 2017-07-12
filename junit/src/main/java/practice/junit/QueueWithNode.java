package practice.junit;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public class QueueWithNode<T> implements Iterable<T>{

	private int size = 0;
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
		if (size == Integer.MAX_VALUE) {
			return false;
		}
		if (size == 0) {
			first = last = new Node(element);
		} else {
			last = last.next = new Node(element);
		}
		size++;
		return true;
	}

	public synchronized T dequeue() {
		if (size == 0) {
			return null;
		}
		Node element = first;
		if (size == 1) {
			first = last = null;
		} else {
			first = first.next;
		}
		size--;
		return element.item;
	}

	public int getSize() {
		return size;
	}
	
	private class QueueIterator implements Iterator<T>{
		private Node current;
		public QueueIterator(){
			current=first;
		}
		public boolean hasNext() {
			return current!=null && current.item!=null;
		}

		public T next() {
			T item= current.item;
			current=current.next;
			return item;
		}
		
		public void remove(){
			
		}
		
	}

	public Iterator<T> iterator() {
		return new QueueIterator();
	}

}
