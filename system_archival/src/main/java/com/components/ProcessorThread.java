/**
 * 
 */
package com.components;

import java.util.concurrent.BlockingQueue;

/**
 * 
 */
public class ProcessorThread implements Runnable {

	private final BlockingQueue<Integer> blockingQueue;
	private final BlockingQueue<String> sendQueue;

	public ProcessorThread(BlockingQueue<Integer> blockingQueue, BlockingQueue<String> sendQueue) {
		this.blockingQueue = blockingQueue;
		this.sendQueue = sendQueue;
	}

	@Override
	public void run() {

		while (true) {
			synchronized (blockingQueue) {
				try {
					int message = blockingQueue.take();
					processMessage(message);
					blockingQueue.notify();
					sendQueue.put("message  :5 messages printed");
					if (blockingQueue.isEmpty())
						blockingQueue.wait();

				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}
		}
	}

	private void processMessage(int message) {
		for (int i = 1; i <= message; i++) {
			System.out.println("consume message : " + i);
		}
	}

}
