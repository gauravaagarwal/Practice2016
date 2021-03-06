package practice.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Before;
import org.junit.Test;

public class TestQueueWithNode {

	private ExecutorService service = Executors.newCachedThreadPool();
	private QueueWithNode<Integer> queue = new QueueWithNode<Integer>();
	
	private Runnable insertWorker = new Runnable(){

		public void run() {
			for (int i=0;i<20;i++)
			queue.enqueue(i);
		}
		
	};
	
	private Runnable deleteWorker = new Runnable(){

		public void run() {
			for (int i=0;i<20;i++)
			assertEquals(i,queue.dequeue().intValue());
		}
		
	};
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testQueue() {
		service.execute(insertWorker);
		service.execute(deleteWorker);
		service.shutdown();
		assertTrue(queue.getSize()<20);
		service.isTerminated();
	}

	@Test
	public void testIterator(){
		for (int i=0;i<=20;i++)
			queue.enqueue(i);
		Iterator<Integer> iterator=queue.iterator();
		for (int i=0;iterator.hasNext();i++) {
			assertEquals(new Integer(i),iterator.next());
		}
	}
}
