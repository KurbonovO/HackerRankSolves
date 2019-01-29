package leetcode_Easy;

import linkedList.Node;

public class ReverseLinkedListBeck {
	public Node reverseLinkedListBeck(Node head) {

		if (head == null || head.next == null) {
			return head;
		}
		
		Node nextNode = head.next;
		Node newHead = reverseLinkedListBeck(nextNode);
		nextNode.next = head;
		head.next = null;
		return newHead;
	}
}
