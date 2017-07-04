package com.java.practice.observer;

public class Event {
	
	String propertyName;
	String oldValue;
	String newValue;
	public Event(String propertyName, String oldValue, String newValue) {
		super();
		this.propertyName = propertyName;
		this.oldValue = oldValue;
		this.newValue = newValue;
	}
	public String getPropertyName() {
		return propertyName;
	}
	public String getOldValue() {
		return oldValue;
	}
	public String getNewValue() {
		return newValue;
	}
	
	

}
