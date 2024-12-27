/**
 * 
 */
package com.even.odd.num;


import java.util.concurrent.CompletableFuture;

/**
 * 
 */
public class EvenOddNumber {

	public static String printNumber(int number) {

		if (number % 2 == 0) {
			return number + ":even";
		} else {
			return number + ":odd";
		}

	}

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		CompletableFuture<Void>[] future = new CompletableFuture[arr.length];

		for (int t = 0; t < arr.length; t++) {
			int num = arr[t];
			future[t] = CompletableFuture.supplyAsync(() -> printNumber(num)).thenAccept(System.out::println);
		}
		CompletableFuture.allOf(future).join();
	}

}
