package leetcodeMedium;

import util.ListNode;

public class RemoveNthNodeFromEndOfListBeck {

	public static ListNode removeNthNodeFromEndOfListBeck(ListNode head, int n) {

		ListNode start = new ListNode(0);
		ListNode slow = start;
		ListNode fast = start;

		start.next = head;

		// Move fast in front so that the gap between slow and fast becomes n
		for (int i = 1; i <= n + 1; i++) {

			fast = fast.next;
		}

		// Move fast to the end, maintaining the gap
		while (fast != null) {

			slow = slow.next;
			fast = fast.next;
		}

		// Skip the desired node
		slow.next = slow.next.next;
		return start.next;
	}
}
