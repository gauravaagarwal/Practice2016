package practice.junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestMyStack {

	@Before
	public void setUp() throws Exception {
	}
	MyStack<Integer> mystack = new MyStack<Integer>(10);
	@Test
	public void testMyStackInt1() {
		MyStack1<Integer> mystack = new MyStack1<Integer>(Integer.class,10);
		for (int i=0;i<10;i++) {
			assertTrue(mystack.push(i));
		}
		for (int i=0;i<10;i++) {
			assertFalse(mystack.push(i));
		}
		for (int i=9;i>=0;i--) {
			assertTrue(mystack.pop()==i);
		}
		for (int i=9;i>=0;i--) {
			assertNull(mystack.pop());
		}
	}
	
	@Test
	public void testMyStackInt() {
		mystack = new MyStack<Integer>(10);
		for (int i=0;i<10;i++) {
			assertTrue(mystack.push(i));
		}
		for (int i=0;i<10;i++) {
			assertFalse(mystack.push(i));
		}
		for (int i=9;i>=0;i--) {
			assertTrue(mystack.pop()==i);
		}
		for (int i=9;i>=0;i--) {
			assertNull(mystack.pop());
		}
	}

}
