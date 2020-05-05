package leetcodeMedium;

import java.util.HashMap;
import java.util.Map;

// Time Complexity = O(1)
// Space Complexity = O

public class LRUCache {

	class DLinkNode {

		int key;
		int value;
		DLinkNode previous;
		DLinkNode next;
	}

	// Always add the new node right after head
	private void addNode(DLinkNode node) {

		node.previous = head;
		node.next = head.next;
		head.next.previous = node;
		head.next = node;
	}

	// Remove an existing node from the linked list.
	private void removeNode(DLinkNode node) {

		DLinkNode previous = node.previous;
		DLinkNode next = node.next;

		previous.next = next;
		next.previous = previous;
	}

	// Move certain node in between to the head
	private void moveToHead(DLinkNode node) {

		removeNode(node);
		addNode(node);
	}

	// Pop the current tail
	private DLinkNode popTail() {

		DLinkNode result = tail.previous;
		removeNode(result);
		return result;
	}

	private Map<Integer, DLinkNode> cache = new HashMap<>();
	private int size;
	private int capacity;
	private DLinkNode head;
	private DLinkNode tail;

	public LRUCache(int capacity) {

		this.size = 0;
		this.capacity = capacity;

		head = new DLinkNode();
		tail = new DLinkNode();

		head.next = tail;
		tail.previous = head;
	}

	public int get(int key) {

		DLinkNode node = cache.get(key);

		if (node == null) {
			return -1;
		}
		moveToHead(node);

		return node.value;
	}

	public void put(int key, int value) {

		DLinkNode node = cache.get(key);

		if (node == null) {

			DLinkNode newNode = new DLinkNode();
			newNode.key = key;
			newNode.value = value;

			cache.put(key, newNode);
			addNode(newNode);

			++size;

			if (size > capacity) {

				// pop the tail
				DLinkNode tail = popTail();
				cache.remove(tail.key);
				--size;
			}
		} else {

			// Update the value
			node.value = value;
			moveToHead(node);
		}
	}

	public static void main(String[] args) {

		LRUCache lruCache = new LRUCache(2);
		
		lruCache.put(1, 1);
		lruCache.put(2, 2);
		lruCache.get(1); 		// returns 1
		lruCache.put(3, 3); 	// evicts key 2
		lruCache.get(2); 		// returns -1 (not found)
		lruCache.put(4, 4); 	// evicts key 1
		lruCache.get(1); 		// returns -1 (not found)
		lruCache.get(3); 		// returns 3
		lruCache.get(4); 		// returns 4
	}
}
