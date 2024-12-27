/**
 * 
 */

/**
 * 
 */
public class ListenerThread {

	public Thread listen() {
		return new Thread(new Runnable() {
			@Override
			public void run() {
				int number = getMessage();
				for (int t = 1; t <= number; t++) {
					System.out.println("messages : " + t);
				}

				SenderThread.setCompletionMessage("completion status ,5 message printed");

			}
		});
	}

	private int getMessage() {
		return 5;

	}

}
