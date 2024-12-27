/**
 * 
 */
package system_archival;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * KISS keeP it simPle and stuPid
 */
public class ThreadPoolExample {

	public static void main(String... str) {

		ExecutorService executor = Executors.newFixedThreadPool(2);

		Runnable task = () -> {
			System.out.println("task one");
		};

		Runnable take1 = () -> {
			System.out.println("task one");
		};

		executor.submit(task);
		executor.submit(take1);
		System.out.println("tasks submitted ");
		executor.shutdown();
	}

}
