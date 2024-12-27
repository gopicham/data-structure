/**
 * 
 */
package com.print.sequence;

/**
 * 
 */
public class PrintCharThread implements Runnable {

	private Object lock;

	public PrintCharThread(Object lock) {
		super();
		this.lock = lock;
	}

	@Override
	public void run() {
		synchronized (lock) {
			for (char ch = 'A'; ch <= 'Z'; ch++) {
				System.out.print(ch);
				try {
					lock.notify();
					lock.wait();
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}
	}

}
