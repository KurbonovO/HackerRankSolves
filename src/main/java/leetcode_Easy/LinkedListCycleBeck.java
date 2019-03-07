package leetcode_Easy;

import linkedList.Node;

public class LinkedListCycleBeck {
	public boolean linkedListCycle(Node node) {

		if (node == null || node.next == null) {
			return false;
		}
		Node slow = node;
		Node fast = node;

		while (fast.next != null && fast.next.next != null) {

			slow = slow.next;
			fast = fast.next.next;
			if (fast == slow) {
				return true;
			}
		}
		return false;
	}
}
