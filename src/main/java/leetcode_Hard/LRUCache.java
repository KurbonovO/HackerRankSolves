package leetcode_Hard;

import java.util.HashMap;
import java.util.Map;

/*146  Design and implement a data structure for Least Recently Used (LRU) cache.
It should support the following operations: get and put. get(key) - Get the value
(will always be positive) of the key if the key exists in the cache, otherwise
return -1. put(key, value) - Set or insert the value if the key is not already
present. When the cache reached its capacity, it should invalidate the least recently
used item before inserting a new item.
LRUCache cache = new LRUCache( 2 		// capacity  );
cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4											*/

public class LRUCache {

	private Map<Integer, DLinkNode> cache;
	DLinkNode tail = null;
	DLinkNode head = null;
	int capacity;

	public LRUCache(int capacity) {
		cache = new HashMap<Integer, DLinkNode>();
		this.capacity = capacity;
	}

	public int get(int key) {
		
		if (cache.containsKey(key)) {
			DLinkNode target = cache.get(key);
			int value = target.value;
			target.update();
			return value;
		} 
		else
			return -1;
	}

	public void set(int key, int value) {
		
		if (cache.containsKey(key)) {
			DLinkNode target = cache.get(key);
			target.value = value;
			target.update();
		} 
		else {
			
			if (capacity == 0)
				return;
			
			if (cache.size() == capacity) {
				cache.remove(head.key);
				head.removeFromHead();
			}
			DLinkNode newNode = new DLinkNode(key, value);
			newNode.append();
			cache.put(key, newNode);
		}
	}

	class DLinkNode {
		int key;
		int value;
		DLinkNode left = null;
		DLinkNode right = null;
		public DLinkNode(int key, int value) {
			this.key = key;
			this.value = value;
		}
	  //remove head from list and update head reference.
		private void removeFromHead() {
		  
			//if 'this' is the only node, set both head and tail to null.
			if (tail == this) {
				head = null;
				tail = null;
			} 
			else {
				head = this.right;
				head.left = null;
			}
		}
		private void update() {
		  
			//no need to update if accessing the most revently used value.
			if (tail == this)
				return;
			
			else {
			  
			  //remove from current postion and update nodes (if any) on both sides.
				if (this != head) {
					this.left.right = this.right;
				} 
				else {
					head = this.right;
				}
				this.right.left = this.left;
			  //append to tail.
				this.append();
			}
		}
		
		private void append() {
			
		  //inserting the first node.
			if (tail == null) {
				head = this;
				tail = this;
			
			} 
		  //appned as tail and update tail reference.
			else {
				this.right = null;
				this.left = tail;
				tail.right = this;
				tail = this;
			}
		}
	}
}

/*The problem can be solved with a hashtable that keeps track of the keys and its
values in the double linked list. One interesting property about double linked
list is that the node can remove itself without other reference. In addition, it
takes constant time to add and remove nodes from the head or tail. One particularity
about the double linked list that I implemented is that I create a pseudo head
and tail to mark the boundary, so that we don�t need to check the NULL node during
the update. This makes the code more concise and clean, and also it is good for
the performance as well														*/
