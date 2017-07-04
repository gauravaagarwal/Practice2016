package com.hackerrank.test.linkedlist;

import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {

	Node<T> first;
	Node<T> last;
	int size = 0;

	private static class Node<T> {
		T entry;
		Node<T> next;

		public Node(T entry, Node<T> next) {
			super();
			this.entry = entry;
			this.next = next;
		}

	}

	public void addElement(T entry) {
		if (null == first && null == last) {
			first = last = new Node<T>(entry, null);
		} else {
			Node<T> node = new Node<T>(entry, first);
			if (first == last) {
				first.next = node;
			} else {
				last.next = node;
			}
			last = node;
		}
		size++;
	}

	public Iterator<T> iterator() {
		return new SubIterator();
	}

	private class SubIterator implements Iterator<T> {
		private Node<T> nextItem;
		int returnedEntries = 0;

		public SubIterator() {
			this.nextItem = first;
		}

		@Override
		public boolean hasNext() {
			if (returnedEntries == size)
				return false;
			return null != nextItem;
		}

		@Override
		public T next() {
			if (returnedEntries == size)
				return null;
			T entry = nextItem.entry;
			nextItem = nextItem.next;
			returnedEntries++;
			return entry;
		}

	}

	public static void main(String[] args) {
		LinkedList<String> myList = new LinkedList<String>();
		myList.addElement("first");
		myList.addElement("zero");
		myList.addElement("second");
		myList.addElement("third");
		for (String str : myList) {
			System.out.println(str);
		}
	}

}
