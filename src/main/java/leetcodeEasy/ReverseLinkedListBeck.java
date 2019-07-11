package leetcodeEasy;

import util.ListNode;

public class ReverseLinkedListBeck {

	public static ListNode reverseList(ListNode head) {

		if (head == null || head.next == null) {
			return head;
		}

		ListNode prevHead = null;
		
		while (head != null) {
			
			ListNode recordNext = head.next;
			head.next = prevHead;
			prevHead = head;
			head = recordNext;
		}
		return prevHead;
	}
}
