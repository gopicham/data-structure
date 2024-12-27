package com.map.hashmap;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HashMap<K, V> {

	private static final int INITIAL_CAPACITY = 16;
	private static final float LOAD_FACTOR = 0.75f;
	private LinkedList<Entry<K, V>>[] table;
	private int size;
	private int threshold;

	@SuppressWarnings("unchecked")
	public HashMap() {
		this.table = new LinkedList[INITIAL_CAPACITY];
		this.size = 0;
		threshold = (int) (INITIAL_CAPACITY * LOAD_FACTOR);

		for (int i = 0; i < INITIAL_CAPACITY; i++) {
			table[i] = new LinkedList<>();
		}
	}

	public int hash(K key) {
		return key == null ? 0 : key.hashCode() % table.length;
	}

	public void put(K key, V value) {

		int index = hash(key);
		LinkedList<Entry<K, V>> bucket = table[index];

		for (Entry<K, V> entry : bucket) {
			if (entry.key.equals(key)) {
				entry.value = value; // Update existing value
				return;
			}
		}
		bucket.add(new Entry<K, V>(key, value));
		size++;
		return;
	}

	public V get(K key) {

		int index = hash(key);
		LinkedList<Entry<K, V>> bucket = table[index];
		for (Entry<K, V> entry : bucket) {
			if (entry.key.equals(key)) {
				return entry.value;
			}
		}
		return null;
	}

	public boolean containsKey(K key) {
		int index = hash(key);

		LinkedList<Entry<K, V>> bucket = table[index];

		for (Entry<K, V> entry : bucket) {
			if (entry.key.equals(key)) {
				return true;
			}
		}
		return false;

	}

	public boolean containsValue(V value) {

		for (List<Entry<K, V>> bucket : table) {
			for (Entry<K, V> entry : bucket) {
				if (entry.value.equals(value)) {
					return true;
				}
			}
		}
		return false;

	}

	public V remove(K key) {
		int index = hash(key);
		LinkedList<Entry<K, V>> bucket = table[index];
		if (bucket != null) {
			Iterator<Entry<K, V>> iterator = bucket.iterator();
			while (iterator.hasNext()) {
				Entry<K, V> entry = iterator.next();
				if (entry.key.equals(key)) {
					iterator.remove();
					size--;
					return entry.value;
				}
			}
		}
		return null;

	}

	public int size() {
		return size;
	}

	public static void main(String... str) {

		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "abc");
		map.put(2, "xys");
		map.put(3, "you");
		map.put(100, "yeag");

		map.put(101, "yeag");
		System.out.println("value : " + map.containsKey(100));
		System.out.println("value : " + map.containsValue("you"));
		map.remove(3);
		System.out.println(map);
		System.out.println("size :" + map.size());

	}
}
