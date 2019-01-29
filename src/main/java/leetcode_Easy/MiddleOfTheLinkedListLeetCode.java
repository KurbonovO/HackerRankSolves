package leetcode_Easy;

import linkedList.Node;

/*Each time, slow go 1 steps while fast go 2 steps. When fast arrives at the end, slow will arrive right in the 
middle */

public class MiddleOfTheLinkedListLeetCode {
	public Node middleOfTheLinkedList(Node head) {

		Node fast = head.next;
		Node slow = head;

		while (fast != null && fast.next != null) {

			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
}
