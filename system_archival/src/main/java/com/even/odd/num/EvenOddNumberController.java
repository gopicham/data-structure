/**
 * 
 */
package com.even.odd.num;

/**
 * 
 */
public class EvenOddNumberController {

	static Object lock = new Object();

	static private int count = 1;

	static class PrintOddNumberThread implements Runnable {

		public void run() {
			while (count < 10) {
				synchronized (lock) {
					if (count % 2 != 0) {
						System.out.println("oddd :" + Thread.currentThread().getName() + "::" + count);
						count++;
					}

				}
			}

		}

	}

	static class PrintEvenNumberThread implements Runnable {

		@Override
		public void run() {
			while (count < 10) {
				synchronized (lock) {
					if (count % 2 == 0) {
						System.out.println("even :" + Thread.currentThread().getName() + "::" + count);
						count++;
					}
				}
			}

		}
	}

	public static void main(String[] args) {

		Thread t1 = new Thread(new PrintEvenNumberThread());
		t1.setName("Thread 1");
		Thread t2 = new Thread(new PrintOddNumberThread());
		t2.setName("Thread 2");
		Thread t3 = new Thread(new PrintEvenNumberThread());
		t3.setName("Thread 3");
		Thread t4 = new Thread(new PrintOddNumberThread());
		t3.setName("Thread 4");
		t1.start();
		t2.start();
		t3.start();
		t4.start();

	}

}
