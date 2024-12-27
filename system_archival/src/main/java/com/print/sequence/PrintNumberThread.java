/**
 * 
 */
package com.print.sequence;

/**
 * 
 */
public class PrintNumberThread implements Runnable {

	private Object lock;

	private int monitor = 1;

	public PrintNumberThread(Object lock) {
		this.lock = lock;
	}

	private void stoProcess() {
		if (monitor == 26) {
			System.exit(0);
		}
	}

	@Override
	public void run() {
		synchronized (lock) {
			for (int i = 1; i < 27; i++) {
				System.out.print(i);
				try {
					stoProcess();
					lock.notify();
					lock.wait();
					monitor++;
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}

	}

}
