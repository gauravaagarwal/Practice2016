package com.java.practice.observer;


import junit.framework.TestCase;

public class TestObserver extends TestCase {
	PersonList list=new PersonList();
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		list.addPerson(list.new Person("Gaurav", 34));
	}
	
	public void testListener(){
		PropertyChangeListener listener = new PropertyChangeListener() {
			
			@Override
			public void onChange(Event event) {
				System.out.println("listener called "+event.newValue);
			}
		};
		list.addListeners(listener);
		list.persons.get(0).setName("Saurabh");
	}
}
