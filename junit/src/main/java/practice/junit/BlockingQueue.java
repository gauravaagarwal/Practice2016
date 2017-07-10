package practice.junit;

import java.util.LinkedList;

public class BlockingQueue<T> {

	private final int limit;
	private LinkedList<T> list = new LinkedList<T>();

	public BlockingQueue(int limit) {
		this.limit = limit;
	}

	public synchronized void enqueue(T element) {
		if (list.size() == limit) {
			try {
				wait();
			} catch (InterruptedException ex) {

			}
		}
		if (list.size() == 0) {
			notifyAll();
		}
		list.add(element);
	}

	public synchronized T dequeue() {
		if(list.size()==0){
			try {
				wait();
			}catch (InterruptedException ex){
				
			}
		}
		if (list.size()==limit){
			notifyAll();
		}
		return list.removeFirst();
	}
	
	public int getSize(){
		return list.size();
	}

}
