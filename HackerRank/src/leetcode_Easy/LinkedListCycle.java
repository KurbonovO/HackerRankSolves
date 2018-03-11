package leetcode_Easy;

import util.ListNode;

/*Given a linked list, determine if it has a cycle in it. Follow up: Can you solve
it without using extra space?												  */

public class LinkedListCycle {

	public boolean hasCycle(ListNode head) {
		
		if (head == null)
			return false;
		
		ListNode walker = head;
		ListNode runner = head;
		
		while (runner.next != null && runner.next.next != null) {
			walker = walker.next;
			runner = runner.next.next;
			
			if (walker == runner)
				return true;
		}
		return false;
	}
}

/*1) Use two pointers, walker and runner.
2) walker moves step by step. runner moves two steps at time.
3) if the Linked List has a cycle walker and runner will meet at some point   */
