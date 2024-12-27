/**
 * 
 */
package com.assesment.client;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 */
public class MessageProcessorController {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Queue<Integer> shared = new LinkedList<Integer>();

		MessageProduceThread produce = new MessageProduceThread(shared);
		produce.publish().start();
		MessageConsumerThread consumerThread = new MessageConsumerThread(shared);	
		consumerThread.subscribe().start();
	}

}
