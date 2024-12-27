/**
 * 
 */
package com.message;

/**
 * 
 */
public class ListenerThread implements Runnable {

	@Override
	public void run() {
		int input = readMessage();
		System.out.println("User input: " + input);
		for (int q = 1; q <= input; q++) {
			System.out.println(q);
		}
		SenderThread.setCompletionMessage("5 messages printed");
	}

	public int readMessage() {
		return 5;
	}

}
