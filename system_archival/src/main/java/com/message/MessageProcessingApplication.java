/**
 * 
 */
package com.message;

/**
 * 
 */
public class MessageProcessingApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Thread listener = new Thread(new ListenerThread());
		listener.start();
		Thread sender = new Thread(new SenderThread());
		
		sender.start();
	}
}
