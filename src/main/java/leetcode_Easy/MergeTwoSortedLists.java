package leetcode_Easy;

import util.ListNode;

/*21 Merge two sorted linked lists and return it as a new list. The new list
should be made by splicing together the nodes of the first two lists.
Input: 1->2->4, 1->3->4							Output: 1->1->2->3->4->4     */

public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode listNodeOne, ListNode listNodeTwo) {

		if (listNodeOne == null)
			return listNodeTwo;
		
		if (listNodeTwo == null)
			return listNodeOne;

		if (listNodeOne.val < listNodeTwo.val) {
			listNodeOne.next = mergeTwoLists(listNodeOne.next, listNodeTwo);
			return listNodeOne;
		} 
		else {
			listNodeTwo.next = mergeTwoLists(listNodeOne, listNodeTwo.next);
			return listNodeTwo;
		}
	}
}