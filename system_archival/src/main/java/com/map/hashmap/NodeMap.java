package com.map.hashmap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("unchecked")
public class NodeMap<K, V> {

	int INITIAL_CAPACITY = 16;
	int size;
	private int threshold;
	private static final float LOAD_FACTOR = 0.75f;

	public Node<K, V>[] table; // Array of linked lists (buckets)

	/**
	 * @param iNITIAL_CAPACITY
	 * @param size
	 * @param threshold
	 * @param table
	 */

	public NodeMap() {
		this.size = 0;
		this.threshold = (int) (INITIAL_CAPACITY * LOAD_FACTOR);
		this.table = new Node[INITIAL_CAPACITY];
	}

	private int hash(K key) {
		return key == null ? 0 : key.hashCode() % table.length;
	}

	public V put(K key, V value) {
		int index = hash(key);
		Node<K, V> entry = table[index];

		while (entry != null) {
			if (entry.key.equals(key)) {
				V oldValue = entry.value;
				entry.value = value; // Replace the value
				return oldValue;
			}
			entry = entry.next;
		}

		// Add a new entry to the table
		Node<K, V> newEntry = new Node<>(key, value);
		newEntry.next = table[index];
		table[index] = newEntry;
		size++;

		if (size >= threshold) {
			resize();
		}

		return null;
	}

	public void remove(K key) {
		int index = hash(key);
		Node<K, V> bucket = table[index];
		for (; bucket != null;) {
			if (bucket.key.equals(key)) {
				table[index] = bucket.next;
				size--;
				break;
			}
		}
	}

	public V get(K key) {

		int index = hash(key);
		Node<K, V> bucket = table[index];
		for (; bucket != null;) {
			if (bucket.key.equals(key)) {
				return bucket.value;
			}
			bucket = bucket.next;
		}
		return null;
	}

	public boolean containsKey(K key) {
		int index = hash(key);
		Node<K, V> bucket = table[index];
		for (; bucket != null;) {
			if (bucket.key.equals(key)) {
				return true;
			}
			bucket = bucket.next;
		}
		return false;
	}

	public boolean containsValue(V value) {
		Node<K, V>[] bucket = table;
		for (Node<K, V> node : bucket) {
			if (node != null) {
				if (node.value.equals(value)) {
					return true;
				}
			}
		}
		return false;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public Set<Node<K, V>> entrySet() {

		final Set<Node<K, V>> set = new HashSet<Node<K, V>>();
		for (Node<K, V> entryNode : table) {
			if (entryNode != null)
				set.add(entryNode);
		}
		return set;
	}

	public Set<K> keySet() {
		final Set<K> set = new HashSet<K>();
		for (Node<K, V> entry : table) {
			if (entry != null) {
				set.add(entry.key);
				if (entry.next != null)
					set.add(entry.next.key);
			}
		}
		return set;
	}

	public Collection<V> values() {
		final Collection<V> values = new ArrayList<V>();
		for (Node<K, V> entry : table) {
			if (entry != null) {
				values.add(entry.value);
				if (entry.next != null) {
					values.add(entry.next.value);
				}
			}

		}
		return values;
	}

	public void clear() {
		table = new Node[INITIAL_CAPACITY];
		size = 0;
	}

	public void resize() {
		Node<K, V>[] bucket = table;
		threshold = (int) (table.length * LOAD_FACTOR);
		size = 0; // Reset size and rehash all entries
		this.table = new Node[INITIAL_CAPACITY * 2];
		for (Node<K, V> entry : bucket) {
			if (entry != null) {
				put(entry.key, entry.value);
			}
		}
	}

	public boolean replace(K key, V value) {
		int index = hash(key);
		Node<K, V> bucket = table[index];
		if (bucket != null && bucket.key.equals(key)) {
			bucket.value = value;
			return true;
		}
		return false;
	}

	public void putAll(K key, V value) {

		Node<K, V> newValue = new Node<K, V>(key, value);

		int index = hash(key);
		Node<K, V> bucket = table[index];

		if (bucket == null) {
			table[index] = newValue;
			return;
		}
		while (bucket != null) {
			if (bucket.key.equals(key)) {
				bucket.value = value;
				return;
			}
			if (bucket.next == null) {
				break;
			}
			bucket = bucket.next;
		}
		bucket.next = newValue;
	}

	public static void main(String... str) {

		NodeMap<Integer, String> map = new NodeMap<Integer, String>();
		System.out.println("map is empty:" + map.isEmpty());
		map.put(10, "tert");
		map.put(20, "gdg");
		map.put(30, "maplll");
		map.put(40, "bdcb");
		map.put(40, "sarewrt");
		map.put(50, "maplll");
		map.put(60, "xxxxxv");

		map.put(70, "tert");
		map.put(80, "gdg");
		map.put(90, "maplll");
		map.put(410, "bdcb");
		map.put(140, "sarewrt");
		map.put(150, "maplll");
		map.put(160, "xxxxxv");

		map.put(110, "tert");
		map.put(120, "gdg");
		map.put(130, "maplll");
		map.put(140, "bdcb");
		map.put(240, "sarewrt");
		map.put(450, "maplll");
		map.put(560, "xxxxxv");
		map.put(100, "9999");

		System.out.println("map size : " + map.size());

		System.out.println(map.toString());
		System.out.println("vale :" + map.get(10));
		System.out.println("vale :" + map.get(20));

		System.out.println("contains key  :" + map.containsKey(60));
		System.out.println("contains value:" + map.containsValue("gdg"));

		System.out.println("map size : " + map.size());
		System.out.println("map is empty:" + map.isEmpty());

		Set<Integer> keys = map.keySet();
		System.out.println("keys are : " + keys);

		Collection<String> values = map.values();
		System.out.println("values are :" + values);

		System.out.println(map.get(10));

		map.replace(100, "*yyyyyyyyyyyyyyy**");
		map.replace(100, "*****TtttTTTTTTTTTTTTTTTTTTTTTT**");

		map.putAll(1011, "******oooooo*******");

		map.putAll(1011, "******IIIII*******");
		map.putAll(1012, "******MMMMM*******");
		map.putAll(1012, "******LLLLL*******");
		map.remove(1011);
		Set<Integer> keys2 = map.keySet();
		System.out.println("keys are : " + keys2);
		Collection<String> value1s = map.values();
		System.out.println("values are :" + value1s);

	}

}
