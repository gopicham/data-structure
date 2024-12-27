/**
 * 
 */
package com.java8;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 
 */
public class SenderThread {

	private final CompletableFuture<String> completionFuture;

	public SenderThread(CompletableFuture<String> future) {
		this.completionFuture = future;
	}

	public void send() {
		try {
			String message = completionFuture.get();
			System.out.println(message);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

	}
}
