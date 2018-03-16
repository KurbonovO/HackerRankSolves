package leetcode_Medium;

import util.ListNode;

/*143 Given a singly linked list L: L0->L1->…->Ln-1->Ln,
reorder it to: L0->Ln->L1->Ln-1->L2->Ln-2->…
You must do this in-place without altering the nodes' values.
For example: Given {1,2,3,4}, reorder it to {1,4,2,3}						  */

public class ReorderList {
	public void reorderList(ListNode head) {
		
		if (head == null || head.next == null)
			return;

		// Find the middle of the list
		ListNode listNodeOne = head;
		ListNode listNodeTwo = head;
		while (listNodeTwo.next != null && listNodeTwo.next.next != null) {
			listNodeOne = listNodeOne.next;
			listNodeTwo = listNodeTwo.next.next;
		}

		// Reverse the half after middle 1->2->3->4->5->6 to 1->2->3->6->5->4
		ListNode preMiddle = listNodeOne;
		ListNode preCurrent = listNodeOne.next;
		
		while (preCurrent.next != null) {
			ListNode current = preCurrent.next;
			preCurrent.next = current.next;
			current.next = preMiddle.next;
			preMiddle.next = current;
		}

		// Start reorder one by one 1->2->3->6->5->4 to 1->6->2->5->3->4
		listNodeOne = head;
		
		while (listNodeOne != preMiddle) {
			preMiddle.next = listNodeTwo.next;
			listNodeTwo.next = listNodeOne.next;
			listNodeOne.next = listNodeTwo;
			listNodeOne = listNodeTwo.next;
			listNodeTwo = preMiddle.next;
		}
	}
}
