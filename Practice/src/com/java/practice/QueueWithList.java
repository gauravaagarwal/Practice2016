package com.java.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gauravaagarwal
 *
 * @param <T>
 */
public class QueueWithList<T> implements Queue<T>{
	
	private List<T> itemList;
	public QueueWithList() {
		itemList=new ArrayList<T>(); 
	}
	@Override
	public boolean add(T item) {
		return itemList.add(item);
	}
	@Override
	public T remove() {
		if (!itemList.isEmpty()) {
			return itemList.remove(0);
		}
		return null;
	}
	@Override
	public T peek() {
		if (!itemList.isEmpty()) {
		return itemList.get(0);
		}
		return null;
	}

}
