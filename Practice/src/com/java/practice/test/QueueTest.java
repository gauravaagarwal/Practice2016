package com.java.practice.test;

import com.java.practice.Queue;
import com.java.practice.QueueWithList;

import junit.framework.TestCase;

public class QueueTest extends TestCase {

	Queue<String> queue = new QueueWithList<String>();

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		queue.add("first");
		queue.add("second");
		queue.add("third");
	}

	public void testRemove() {
		assertEquals("first",queue.remove());
		assertEquals("second",queue.remove());
		assertEquals("third",queue.remove());
		assertEquals(null,queue.remove());
	}
	
	public void testPeekAndRemove() {
		assertEquals("first",queue.peek());
		assertEquals("first",queue.remove());
		assertEquals("second",queue.peek());
		assertEquals("second",queue.remove());
		assertEquals("third",queue.peek());
		assertEquals("third",queue.remove());
		assertEquals(null,queue.peek());
		assertEquals(null,queue.remove());

	}

}
