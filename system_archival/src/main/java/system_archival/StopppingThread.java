/**
 * 
 */
package system_archival;

import java.util.stream.IntStream;

/**
 * 
 */
public class StopppingThread implements Runnable {
	private static boolean EXIST;

	public StopppingThread(String name) {
		EXIST = false;
	}

	public static void main(String[] args) {
		StopppingThread task = new StopppingThread("Thread One");
		StopppingThread task1 = new StopppingThread("Thread two");
		Thread t1 = new Thread(task);
		Thread t2 = new Thread(task1);
		t1.start();
		t2.start();
		try {
			Thread.sleep(1000);
			System.out.println("stopping");
			task.stop();
			task1.stop();
			System.out.println("stopping end");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (!EXIST) {
			IntStream.range(1, 5).forEach(value -> System.out.println(value));
		}
		System.out.println("Executed ...!!!" + EXIST);
	}

	private void stop() {
		System.out.println("stopping");
		EXIST = true;
	}

}
