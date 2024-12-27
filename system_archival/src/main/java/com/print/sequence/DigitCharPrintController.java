/**
 * 
 */
package com.print.sequence;

/**
 * 
 */
public class DigitCharPrintController {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {

		Object lock = new Object();
		Thread t1 = new Thread(new PrintCharThread(lock));
		Thread t2 = new Thread(new PrintNumberThread(lock));
		t1.start();
		t2.start();
	}

}
