package leetcodeEasy;

import util.ListNode;

public class MergeTwoSortedListsLeetCode {

	public ListNode mergeTwoLists(ListNode listNodeOne, ListNode listNodeTwo) {

		if (listNodeOne == null) {

			return listNodeTwo;
		}

		if (listNodeTwo == null) {

			return listNodeOne;
		}

		if (listNodeOne.val < listNodeTwo.val) {

			listNodeOne.next = mergeTwoLists(listNodeOne.next, listNodeTwo);
			return listNodeOne;
		} else {

			listNodeTwo.next = mergeTwoLists(listNodeOne, listNodeTwo.next);
			return listNodeTwo;
		}
	}

}
