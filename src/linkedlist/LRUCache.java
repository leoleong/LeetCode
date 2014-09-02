/**
 * Problem:
 * Design and implement a data structure for Least Recently Used (LRU) cache. 
 * It should support the following operations: get and set.
 * 
 * get(key) - 
 * 		Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) - 
 * 		Set or insert the value if the key is not already present. 
 * 		When the cache reached its capacity, 
 * 		it should invalidate the least recently used item before inserting a new item.
 */
package linkedlist;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

	private int capacity;
	private Map<Integer, Node> map;
	private Node head;

	public LRUCache(int capacity) {

		this.capacity = capacity;
		map = new HashMap<Integer, Node>();
		head = null;
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			Node node = map.get(key);
			detach(node);
			attach(node);
			return map.get(key).value;
		}

		return -1;
	}

	public void set(int key, int value) {
		if (map.containsKey(key)) {
			Node node = map.get(key);
			node.value = value;
			detach(node);
			attach(node);
		} else {
			Node node = new Node(key, value);
			map.put(key, node);
			attach(node);
			if (map.size() == capacity) {
				Node last = head.prev;
				detach(last);
				map.remove(last);
			}
		}
	}

	private void detach(Node node) {
		if (node == head) {
			head = node.next;
		}
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}

	private void attach(Node node) {
		if (head == null) {
			head = node;
			head.prev = node;
			head.next = node;
		} else {
			node.prev = head.prev;
			head.prev.next = node;
			node.next = head;
			head.prev = node;
			head = node;
		}
	}

	class Node {
		int key, value;
		Node prev, next;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}
}
