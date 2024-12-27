/**
 * 
 */
package com.thread.safe;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class ConcurrentTreeMap {

	private Map<Integer, String> concurrentTreeMap;

	public ConcurrentTreeMap(Map<Integer, String> concurrentTreeMap) {
		this.concurrentTreeMap = concurrentTreeMap;
	}

	public Thread writer() {
		return new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {
					System.out.println("writer thread :" + i);
					concurrentTreeMap.put(i, "write-" + i);
					
					System.out.println(concurrentTreeMap.get(i) + " ");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
	}

	public Thread reader() {
		return new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {
					String value = concurrentTreeMap.get(i);
					concurrentTreeMap.put(i+1, "write-" + i+2);
					System.out.println(value + " ");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
	}

	public static void main(String... str) {

		HashMap<Integer, String> concurrentTreeMap = new HashMap<Integer, String>();

		ConcurrentTreeMap tMap = new ConcurrentTreeMap(concurrentTreeMap);

		Thread t1 = tMap.writer();
		t1.start();
		Thread t2 = tMap.reader();

		t2.start();

		Thread t3 = tMap.writer();
		t3.start();
		Thread t4 = tMap.reader();
		t4.start();
		Thread t5 = tMap.writer();
		t5.start();
		Thread t6 = tMap.reader();

		t6.start();

		Thread t7 = tMap.writer();
		t7.start();
		Thread t8 = tMap.reader();
		t8.start();

	}

}
