package leetcodeEasy;

import util.ListNode;

public class DeleteNodeInALinkedListD {

	public void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}
}
