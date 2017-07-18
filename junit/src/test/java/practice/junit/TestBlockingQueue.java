package practice.junit;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Before;
import org.junit.Test;

public class TestBlockingQueue {

	@Before
	public void setUp() throws Exception {

	}

	private final static int queueLimit = 5;
	private final static int dataLimit = 20;
	BlockingQueue<String> queue = new BlockingQueue<String>(queueLimit);

	Callable<Boolean> insertWorker = new Callable<Boolean>() {
		public Boolean call() throws Exception {
			int i = 1;
			while (i <= dataLimit) {
				queue.enqueue("First" + i);
				System.out.println(">>First" + (i));
				i++;
				
			}
			return true;
		}

	};
	Callable<Boolean> removeWorker = new Callable<Boolean>() {
		public Boolean call() throws Exception {
			int i = 1;
			Thread.sleep(Math.round(Math.random()) % 2000);
			while (i <=dataLimit) {
				System.out.println("           "+ queue.dequeue()+">>" );
				i++;
			}
			return true;
		}

	};

	@Test
	public void testQqueue() {
		ExecutorService service = Executors.newFixedThreadPool(2);
		Future<Boolean> future = service.submit(insertWorker);
		service.submit(removeWorker);
		// System.out.println(queue);
		assertTrue(queueLimit >= queue.getSize());

		service.shutdown();
		/*while (!service.isTerminated()) {
		}*/
		assertTrue(queueLimit >= queue.getSize());
		// System.out.println(queue);
	}

}
