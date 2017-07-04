package com.java.practice.observer;

import java.util.ArrayList;
import java.util.List;

public class PersonList {
	List<PropertyChangeListener> listeners = new ArrayList<PropertyChangeListener>();
	List<Person> persons=new ArrayList<Person>();
	public void addPerson(Person person){
		persons.add(person);
	}
	
	public class Person {
		String name;
		int age;

		public Person(String name, int age) {
			super();
			this.name = name;
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			notifyListeners(this,"name",name,this.name);
			this.name = name;
			
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}
	}

	public void notifyListeners(Person person, String propertyName, String newValue, String oldValue) {
		for (PropertyChangeListener listener : listeners) {
			listener.onChange(new Event(propertyName,oldValue,newValue));
		}

	}

	public void addListeners(PropertyChangeListener listener) {
		this.listeners.add(listener);
	}

}
