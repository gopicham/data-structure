/**
 * 
 */
package com.map.hashmap;

import java.util.Objects;

/**
 * 
 */
public class Node<K, V> {

	public K key;

	public V value;
	public Node<K, V> next; // For collision resolution with chaining

	Node(K key, V value) {
		this.key = key;
		this.value = value;
		this.next = null;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	@Override
	public int hashCode() {
		return Objects.hash(key, next, value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		return Objects.equals(key, other.key) && Objects.equals(next, other.next) && Objects.equals(value, other.value);
	}

	@Override
	public String toString() {
		return "Node [key=" + key + ", value=" + value + ", next=" + next + "]";
	}
}
