package leetcodeEasy;

import util.ListNode;

public class ReverseLinkedList {

	public ListNode reverseLinkedList(ListNode head) {

		// Null check
		if (head == null || head.next == null) {
			return head;
		}

		ListNode previousHead = null;

		while (head != null) {

			ListNode recordNext = head.next;
			head.next = previousHead;
			previousHead = head;
			head = recordNext;
		}
		return previousHead;
	}

}
