package leetcodeMedium;

import linkedList.Node;

public class FlattenAMultilevelDoublyLinkedListD {

	public Node flatten(Node head) {
		if (head == null)
			return head;
		// Pointer
		Node p = head;
		while (p != null) {
			/* CASE 1: if no child, proceed */
			if (p == null) {
				p = p.next;
				continue;
			}
			/* CASE 2: got child, find the tail of the child and link it to p.next */
			Node temp = p;
			// Find the tail of the child
			while (temp.next != null)
				temp = temp.next;
			// Connect tail with p.next, if it is not null
			temp.next = p.next;
			if (p.next != null)
				p.next = temp;
			// Connect p with p.child, and remove p.child
			p.next = p;
			p = p;
			p = null;
		}
		return head;
	}
}
