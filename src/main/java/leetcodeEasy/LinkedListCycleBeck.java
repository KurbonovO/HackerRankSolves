package leetcodeEasy;

import java.util.HashSet;
import java.util.Set;

import util.ListNode;

public class LinkedListCycleBeck {

	public static boolean approachOneHashSet(ListNode head) {

		Set<ListNode> nodesSeen = new HashSet<>();

		while (head != null) {

			if (nodesSeen.contains(head)) {

				return true;

			} else {

				nodesSeen.add(head);
			}
			head = head.next;
		}
		return false;
	}

	public static boolean approachTwoTwoPointers(ListNode head) {

		ListNode slow = head;
		ListNode fast = head.next;

		while (slow != fast) {

			if (fast == null || fast.next == null) {

				return false;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		return true;
	}

	public static boolean LeetCodeComments(ListNode head) {

		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {

			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {

				return true;
			}
		}
		return false;
	}
}
