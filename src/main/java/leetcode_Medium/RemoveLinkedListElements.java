package leetcode_Medium;

import util.ListNode;

/*203 Remove all elements from a linked list of integers that have value val
Input:  1->2->6->3->4->5->6, val = 6				Output: 1->2->3->4->5	 */

public class RemoveLinkedListElements {
	public ListNode removeElements(ListNode head, int val) {

		if (head == null) {
			return null;
		}

		ListNode next = removeElements(head.next, val);

		if (head.val == val) {
			return next;
		}

		head.next = next;
		return head;
	}
}
