/**
 * 
 */
package com.even.odd.num;

/**
 * 
 */
public class PrintEvenNumberThread implements Runnable {

	private Object lock;
	private int count;

	public PrintEvenNumberThread(Object lock, int count) {
		this.lock = lock;
		this.count = count;
	}

	@Override
	public void run() {
		while (count <= 10) {
			synchronized (lock) {
				if (count % 2 == 0) {
					System.out.println("even :" + count);
					count++;
				}
			}

		}

	}

}