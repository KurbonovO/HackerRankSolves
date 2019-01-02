package leetcode_Medium;

import java.util.ArrayList;
import java.util.Random;

import util.ListNode;

/*Given a singly linked list, return a random node's value from the linked
list. Each node must have the same probability of being chosen.
// Init a singly linked list [1,2,3].
ListNode head = new ListNode(1);
head.next = new ListNode(2);
head.next.next = new ListNode(3);
Solution solution = new Solution(head);
// getRandom() should return either 1, 2, or 3 randomly. Each element should
have equal probability of returning.
solution.getRandom();														 */

public class LinkedListRandomNode {
	
	private ListNode head;
	private Random random;

	/**@param head The linked list's head. Note that the head is guaranteed to
	 * be not null, so it contains at least one node*/
	public LinkedListRandomNode(ListNode head) {
		this.head = head;
		this.random = new Random();
	}

	/** Returns a random node's value. */
	public int getRandom() {
		
		int k = 1;
		ListNode node = this.head;
		int i = 0;
		ArrayList<Integer> reservoir = new ArrayList<Integer>();

		while (i < k && node != null) {
			
			reservoir.add(node.val);
			node = node.next;
			i++;
		}
		
		// i == k => i == k+1
		i++; 
		
		while (node != null) {
			
			if (random.nextInt(i) < k) {
				
				reservoir.set(random.nextInt(k), node.val);
			}
			i++;
			node = node.next;
		}
		// or return reservoir when k > 1;
		return reservoir.get(0);
	}
}
