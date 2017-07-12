package practice.junit;

import java.lang.reflect.Array;


public class MyStack1<T> {
	private T [] data =null;
	private int index = -1;

	MyStack1(Class<T> c,int limit){
		data = (T[]) Array.newInstance(c, limit);
	}

	public boolean push(T element) {
		if (data.length <= index+1) {
			return false;
		}
		index++;
		data[index] = element;
		return true;

	}

	public T pop() {
		if (index == -1)
			return null;
		T element = data[index];
		index--;
		return element;
	}
}