package leetcodeEasy;

import util.ListNode;

public class ReverseLinkedList {

	public ListNode reverseLinkedList(ListNode head) {

		// Null check
		if (head == null || head.next == null) {
			return head;
		}

		ListNode newHead = reverseLinkedList(head.next);

		head.next.next = head;
		head.next = null;

		return newHead;
	}

}
