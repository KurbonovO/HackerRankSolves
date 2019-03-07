package leetcode_Easy;

import linkedList.Node;

public class ReverseLinkedListBeck {
	public Node reverseLinkedListBeck(Node head) {

		if (head == null) {
			return null;
		}

		Node newNode = null;

		while (head != null) {

			Node next = head.next;
			head.next = newNode;
			newNode = head;
			head = next;
		}
		return newNode;
	}
}
