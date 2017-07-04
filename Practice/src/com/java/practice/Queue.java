package com.java.practice;

/**
 * Sample queue interface
 * @author gauravaagarwal
 *
 * @param <T>
 */
public interface Queue<T> {
	
	/**
	 * @param item
	 * @return 
	 */
	public boolean add(T item);
	/**
	 * @return
	 */
	public T remove();
	/**
	 * @return
	 */
	public T peek();

}
