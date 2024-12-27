/**
 * 
 */

/**
 * 
 */
public class MessagePublisherController {

	public static void main(String[] args) {

		SenderThread sendrThread = new SenderThread();
		ListenerThread listnerThread = new ListenerThread();
		listnerThread.listen().start();
		sendrThread.send().start();

	}

}
