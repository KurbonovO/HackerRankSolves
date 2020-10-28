package leetcodeEasy;

import util.ListNode;

public class CountNodes {

	public int countNodes(ListNode head) {

		int count = 1;
		ListNode current = head;

		while (current.next != null) {

			current = current.next;
			count += 1;

		}
		return count;
	}

}
