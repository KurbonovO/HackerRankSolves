package leetcodeEasy;

import util.ListNode;

/**
 * Time Complexity: O(n) Assume that n is the list's length, the time complexity is O(n)
 * Space Complexity: O(n) The extra space comes from implicit stack space due to recursion.
 * The recursion could go up to n levels deep.
 */
public class ReverseLinkedList {

	public ListNode reverseLinkedList(ListNode head) {

		if (head == null || head.next == null) {
			return head;
		}

		ListNode p = reverseLinkedList(head.next);
		head.next.next = head;
		head.next = null;
		return p;
	}

}
