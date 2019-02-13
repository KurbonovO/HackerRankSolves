package leetcode_Easy;

import linkedList.Node;

public class MergeTwoSortedListsLeetCode {
	public Node mergeTwoSortedListsBeck(Node l1, Node l2) {

		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}

		if (l1.data < l2.data) {
			l1.next = mergeTwoSortedListsBeck(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoSortedListsBeck(l2.next, l1);
			return l2;
		}
	}
}
