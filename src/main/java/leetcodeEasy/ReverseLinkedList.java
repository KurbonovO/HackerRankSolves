package leetcodeEasy;

import util.ListNode;

/**
Time complexity: O(n)
Space complexity: O(1)
*/
public class ReverseLinkedList {

	public ListNode reverseLinkedList(ListNode head) {

		// Null check
		if (head == null || head.next == null) {
			return head;
		}

		ListNode reversedLinkedList = null;

		while (head != null) {

			ListNode recordNext = head.next;
			head.next = reversedLinkedList;
			reversedLinkedList = head;
			head = recordNext;
		}
		return reversedLinkedList;
	}

}
