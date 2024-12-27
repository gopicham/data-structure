/**
 * 
 */
package com.message;

/**
 * 
 */
public class SenderThread implements Runnable {

	private static String completionMessage = null;

	@Override
	public void run() {
		if (completionMessage != null)
			System.out.println("\n" + completionMessage);
	}

	public static void setCompletionMessage(String completionMessage) {
		SenderThread.completionMessage = completionMessage;
	}

}
