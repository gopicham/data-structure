/**
 * 
 */
package com.components;

import java.util.concurrent.BlockingQueue;

/**
 * 
 */
public class ListenerThread implements Runnable {

	private BlockingQueue blockingQueue;

	private BlockingQueue sendQueue;

	public ListenerThread(BlockingQueue blockingQueue, BlockingQueue sendQueue) {
		this.blockingQueue = blockingQueue;
		this.sendQueue = sendQueue;
	}

	@Override
	public void run() {

		while (true) {
			synchronized (blockingQueue) {
				try {
					if (!sendQueue.isEmpty()) {
						Object message = sendQueue.take();
						System.out.println(message);
					}
					int number = this.readMessage();
					blockingQueue.put(number);
					System.out.println("put message into queue: " + number);
					blockingQueue.notify();
					if (blockingQueue.size() == 1)
						blockingQueue.wait();

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	private int readMessage() {

		return 10;
	}

}
