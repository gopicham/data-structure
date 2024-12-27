/**
 * 
 */
package system_archival;

/**
 * 
 */
public class SingleTaskByManyThread extends Thread {

	public void run() {
		for (int k = 0; k < 5; k++) {
			System.out.println(k + "::" + Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String... str) {
		SingleTaskByManyThread singleTask = new SingleTaskByManyThread();
		Thread t1 = new Thread(singleTask);
		Thread t2 = new Thread(singleTask);
		// Thread t3 = new Thread(singleTask);
		t1.start();
		t2.start();
		// t3.start();

	}
}
