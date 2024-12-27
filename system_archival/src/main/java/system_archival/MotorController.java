/**
 * 
 */
package system_archival;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.components.ListenerThread;
import com.components.ProcessorThread;

/**
 * 
 */
public class MotorController {

	public static void main(String[] args) {

		final BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<Integer>();
		final BlockingQueue<String> sendQueue = new LinkedBlockingQueue<String>();

		Thread t1 = new Thread(new ListenerThread(blockingQueue,sendQueue));
		Thread t2 = new Thread(new ProcessorThread(blockingQueue,sendQueue));

		t1.start();
		t2.start();

	}

}
