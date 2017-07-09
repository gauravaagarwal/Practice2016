package practice.junit;

public class ThreadTest {
	public static void main(String[] args) {
		Thread t1 = new Thread();
		System.out.println("set priority" + t1.getPriority());
		t1.start();
		t1.setPriority(4);
		System.out.println("set priority" + t1.getPriority());
		
		TestDaemonThread1 tx=new TestDaemonThread1();//creating thread  
		  TestDaemonThread1 t2=new TestDaemonThread1();  
		  TestDaemonThread1 t3=new TestDaemonThread1();  
		  
		  tx.setDaemon(true);//now t1 is daemon thread  
		    
		  tx.start();//starting threads  
		  t2.start();  
		  t3.start();  
	}
}

class TestDaemonThread1 extends Thread {
	public void run() {
		if (Thread.currentThread().isDaemon()) {// checking for daemon thread
			System.out.println("daemon thread work");
		} else {
			System.out.println("user thread work");
		}
	}

}
