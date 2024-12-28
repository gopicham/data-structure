package com.map.hashmap;

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
		return key.hashCode() % table.length;
	}

	public void put(K key, V value) {

		int index = hash(key);
		Node<K, V> newNode = new Node<K, V>(key, value);

		Node<K, V> bucket = table[index];

		if (bucket == null) {
			table[index] = newNode;
			size++;
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
		bucket.next = newNode;
		size++;
		if (size >= threshold) {
			// resize();
		}
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

	public static void main(String... str) {

		NodeMap<Integer, String> map = new NodeMap<Integer, String>();

		map.put(10, "tert");
		map.put(20, "gdg");
		map.put(30, "maplll");
		map.put(40, "bdcb");
		map.put(40, "sarewrt");
		map.put(50, "maplll");
		map.put(60, "xxxxxv");

		System.out.println("map size : " + map.size());

		// map.remove(10);
		//
		map.remove(20);

		System.out.println(map.toString());
		System.out.println("vale :" + map.get(10));
		System.out.println("vale :" + map.get(20));

		System.out.println("contains key  :" + map.containsKey(60));
		System.out.println("contains value:" + map.containsValue("gdg"));

		System.out.println("map size : " + map.size());

	}

}
