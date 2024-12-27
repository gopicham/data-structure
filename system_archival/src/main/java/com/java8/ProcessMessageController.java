/**
 * 
 */
package com.java8;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 */
public class ProcessMessageController {

	public static void main(String... args) {

		ExecutorService executorService = Executors.newFixedThreadPool(2);

		CompletableFuture<String> completionFuture = new CompletableFuture<String>();

		executorService.submit(() -> {
			new ListenerThread(completionFuture).listen();
		});
		executorService.submit(() -> {
			new SenderThread(completionFuture).send();
		});

		executorService.shutdown();
	}

}
