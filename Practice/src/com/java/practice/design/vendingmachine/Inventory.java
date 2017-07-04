package com.java.practice.design.vendingmachine;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravaagarwal
 *
 * @param <T>
 */
public class Inventory<T> {
	/**
	 * 
	 */
	private Map<T, Integer> items = new HashMap<T, Integer>();

	/**
	 * @param item
	 * @param quantity
	 */
	public void addItem(T item, int quantity) {
		if (quantity > 0)
			items.put(item, getItemCount(item) + quantity);
	}

	/**
	 * @param item
	 * @return
	 */
	public int getItemCount(T item) {
		return items.get(item);
		
	}

	/**
	 * @param item
	 * @return
	 */
	public void removeItem(T item) {
		items.put(item, getItemCount(item) - 1);
	}
	/**
	 * @param item
	 * @return
	 */
	public boolean checkItemCount(T item) {
		return items.get(item)>0;
		
	}
	/**
	 * 
	 */
	public void reset() {
		items.clear();
	}

}
