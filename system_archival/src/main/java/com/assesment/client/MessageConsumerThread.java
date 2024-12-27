/**
 * 
 */
package com.assesment.client;

import java.util.Queue;

/**
 * 
 */
public class MessageConsumerThread {

	private Queue<Integer> shared;

	public MessageConsumerThread(Queue<Integer> shared) {
		this.shared = shared;
	}

	public Thread subscribe() {
		return new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					if (!shared.isEmpty()) {
						Integer data = shared.poll();
						System.out.println("massage consumed:" + data);
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		});
	}
}
