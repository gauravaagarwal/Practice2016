package practice.junit;

public class MyStack {
	private static final int LIMIT = 10;
	private int[] data = new int[LIMIT];
	private int index = -1;

	public boolean push(int element) {
		if (data.length == LIMIT) {
			return false;
		}
		index++;
		data[index] = element;
		return true;

	}

	public int pop() {
		if (index == -1)
			throw new RuntimeException("Stack already Empty");
		int element = data[index];
		index--;
		return element;
	}
}