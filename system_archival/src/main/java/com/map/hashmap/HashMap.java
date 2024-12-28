package com.map.hashmap;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
@SuppressWarnings("unchecked")
public class HashMap<K, V> {

	private static final int INITIAL_CAPACITY = 16;
	private static final float LOAD_FACTOR = 0.75f;
	private LinkedList<Entry<K, V>>[] table;
	private int size;
	private int threshold;


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

		if (size >= threshold) {
			resize();
		}

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

	public Set<Entry<K, V>> entrySet() {

		Set<Entry<K, V>> entry = new HashSet<Entry<K, V>>();
		for (LinkedList<Entry<K, V>> bucket : table) {
			Iterator<Entry<K, V>> itr = bucket.iterator();
			while (itr.hasNext()) {
				Entry<K, V> type = itr.next();
				entry.add(type);
			}
		}
		return entry;
	}

	public Set<K> keySet() {

		Set<K> keys = new HashSet<K>();
		for (LinkedList<Entry<K, V>> bucket : table) {
			Iterator<Entry<K, V>> itr = bucket.iterator();
			while (itr.hasNext()) {
				Entry<K, V> type = itr.next();
				keys.add(type.getKey());
			}
		}
		return keys;
	}

	private void resize() {
		LinkedList<Entry<K, V>>[] oldTable = table;
		table = new LinkedList[INITIAL_CAPACITY * 2];
		threshold = (int) (table.length * LOAD_FACTOR);
		size = 0; // Reset size and rehash all entries
		
		for (int i = 0; i < table.length; i++) {
			table[i] = new LinkedList<>();
		}
		

		// Rehash all existing entries
		for (LinkedList<Entry<K, V>> node : oldTable) {
			Iterator<Entry<K, V>> itr = node.iterator();
			while (itr.hasNext()) {
				Entry<K, V> entry = itr.next();
				put(entry.getKey(), entry.getValue());
			}
		}
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
		map.put(1, "abc");
		map.put(2, "xys");
		map.put(3, "you");
		map.put(100, "yeag");

		map.put(101, "yeag");
		map.put(1, "abc");
		map.put(2, "xys");
		map.put(3, "you");
		map.put(100, "yeag");

		map.put(102, "yeag");
		map.put(4, "abc");
		map.put(5, "xys");
		map.put(6, "you");
		map.put(1600, "yeag");

		map.put(1081, "yeag");
		map.put(17, "abc");
		map.put(7, "xys");
		map.put(8, "you");
		map.put(1900, "yeag");

		map.put(1001, "yeag");
		
		System.out.println("value : " + map.containsKey(100));
		System.out.println("value : " + map.containsValue("you"));
		map.remove(3);

		Set<Entry<Integer, String>> set = map.entrySet();
		System.out.println("-------------------------------------------------------------");
		for (Entry<Integer, String> entrySet : set) {
			System.out.println("key :" + entrySet.key + ":values:" + entrySet.value);
		}
		System.out.println("-------------------------------------------------------------");

		Set<Integer> keySet = map.keySet();
		System.out.println("-------------------------------------------------------------");
		for (Integer key : keySet) {

			String values = map.get(key);
			System.out.println(values + " ");
		}
		System.out.println("-------------------------------------------------------------");
		System.out.println("size :" + map.size());

	}
}
