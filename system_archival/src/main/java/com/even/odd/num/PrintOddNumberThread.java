/**
 * 
 */
package com.even.odd.num;

/**
 * 
 */
public class PrintOddNumberThread implements Runnable {

	private Object lock;
	private int count;

	public PrintOddNumberThread(Object lock, int count) {
		this.lock = lock;
		this.count = count;
	}

	public void run() {
		while (count <= 10) {
			synchronized (lock) {
				if (count % 2 != 0) {
					System.out.println("oddd :" + count);
					count++;
				}
			}
		}

	}

}
