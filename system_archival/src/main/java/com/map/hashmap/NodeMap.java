package com.map.hashmap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author manjunath.gopichand
 */

@SuppressWarnings("unchecked")
public class NodeMap<K, V> {

	private final int INITIAL_CAPACITY = 16;
	private int size;
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

		Node<K, V>[] entryNode = table;
		for (int i = 0; i < entryNode.length; i++) {
			Node<K, V> entry = entryNode[i];
			while (entry != null) {
				set.add(entry);
				entry = entry.next;
			}
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

}
