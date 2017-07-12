package practice.junit;

import java.lang.reflect.Array;

public class MyStack<T> {
	private Node<T>[] data =null;
	private int index = -1;
	MyStack(final int limit){
		data = new Node[limit];
	}
	MyStack(Class<T> c,int limit){
		data = (Node<T>[]) Array.newInstance(c, limit);
	}
	private static class Node<T>{
		T element;
		Node(T element){
			this.element=element;
		}
	}
	public boolean push(T element) {
		if (data.length <= index+1) {
			return false;
		}
		index++;
		data[index] = new Node<T>(element);
		return true;

	}

	public T pop() {
		if (index == -1)
			return null;
		T element = data[index].element;
		index--;
		return element;
	}
}