/**
 * 
 */
package com.java8;

import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

/**
 * 
 */
public class ListenerThread {

	private final CompletableFuture<String> completionFuture;

	public ListenerThread(CompletableFuture<String> future) {
		this.completionFuture = future;
	}

	public void listen() {
		int userPayLoad = readMessage();
		System.out.println("user inputs:" + userPayLoad);
		IntStream.range(1, userPayLoad).forEach(System.out::println);
		completionFuture.complete("5 messages printed");

	}

	public int readMessage() {
		return 5;

	}

}
