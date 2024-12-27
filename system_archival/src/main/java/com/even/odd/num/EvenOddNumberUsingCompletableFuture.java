/**
 * 
 */
package com.even.odd.num;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 */
public class EvenOddNumberUsingCompletableFuture {

	static int counter = 1;

	public static void main(String[] args) {

		ExecutorService threadPoll = Executors.newFixedThreadPool(2);

		CompletableFuture<Void> evenFuture = CompletableFuture.runAsync(() -> {
			while (counter < 10) {
				if (counter % 2 == 0) {
					System.out.println("even::" + Thread.currentThread().getName() + "::" + counter);
					counter++;
				}
			}

		}, threadPoll);

		CompletableFuture<Void> oddFuture = CompletableFuture.runAsync(() -> {
			while (counter < 10) {
				if (counter % 2 != 0) {
					System.out.println("odd ::" + Thread.currentThread().getName() + "::" + counter);
					counter++;
				}
			}

		}, threadPoll);

		CompletableFuture.allOf(evenFuture, oddFuture).join();
		threadPoll.shutdown();
	}

}
