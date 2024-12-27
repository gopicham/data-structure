/**
 * 
 */

/**
 * 
 */
public class SenderThread {

	private static String completionMessage = null;

	public Thread send() {
		return new Thread(new Runnable() {
			@Override
			public void run() {
				if (null != completionMessage) {
					System.out.println(completionMessage);
				}
			}
		});
	}

	public static void setCompletionMessage(String completionMessage) {
		SenderThread.completionMessage = completionMessage;
	}
}
