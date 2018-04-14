package leetcode_Hard;

import util.ListNode;

/*25 Given a linked list, reverse the nodes of a linked list k at a time and
return its modified list. k is a positive integer and is less than or equal to
the length of the linked list. If the number of nodes is not a multiple of k
then left-out nodes in the end should remain as it is.
Given this linked list: 1->2->3->4->5For k = 2, 
you should return: 2->1->4->3->5
For k = 3, you should return: 3->2->1->4->5								     */

public class ReverseNodesInKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
		
		int n = 0;
		for (ListNode i = head; i != null; n++, i = i.next);

		ListNode dmy = new ListNode(0);
		dmy.next = head;
		
		for (ListNode prev = dmy, tail = head; n >= k; n -= k) {
			
			for (int i = 1; i < k; i++) {
				ListNode next = tail.next.next;
				tail.next.next = prev.next;
				prev.next = tail.next;
				tail.next = next;
			}
			prev = tail;
			tail = tail.next;
		}
		return dmy.next;
	}
}