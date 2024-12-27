/**
 * 
 */
package com.assesment.client;

import java.util.Queue;

/**
 * 
 */
public class MessageProduceThread {

	private Queue<Integer> shared;

	public MessageProduceThread(Queue<Integer> shared) {
		this.shared = shared;
	}

	public Thread publish() {

		return new Thread(new Runnable() {
			@Override
			public void run() {
				int counter = 1;
				while (true) {
					if (counter <= 5) {
						shared.offer(counter);
						System.out.println("massage produced:" + counter);
						counter++;
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		});
	}
}
