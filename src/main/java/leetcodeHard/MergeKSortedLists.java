package leetcodeHard;

import java.util.Arrays;

import util.ListNode;

/**
Time complexity: O(nlogk)
*/

public class MergeKSortedLists {

	public ListNode mergeKSortedLists(ListNode[] lists) {

		if (lists.length == 0) {

			throw new IllegalArgumentException();

		} else if (lists.length == 1) {

			return lists[0];

		} else if (lists.length == 2) {

			return mergeTwoLists(lists[0], lists[1]);
		}

		return mergeTwoLists(mergeKSortedLists(Arrays.copyOfRange(lists, 0, lists.length / 2)),
				mergeKSortedLists(Arrays.copyOfRange(lists, lists.length / 2, lists.length)));
	}

	/**
	 * Same as the Merge two sorted lists problem.
	 */
	private ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}

		if (l1.val < l2.val) {

			l1.next = mergeTwoLists(l1.next, l2);
			return l1;

		} else {
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
	}

}
