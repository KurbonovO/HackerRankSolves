package leetcode_Medium;

import util.ListNode;

/*61 Given a list, rotate the list to the right by k places, where k is 
non-negative Given 1->2->3->4->5->NULL and k = 2, return 4->5->1->2->3->NU	 */

public class RotateList {
	public ListNode rotateRight(ListNode listNodeParam, int n) {
		
		if (listNodeParam != null) {
			ListNode listNode = listNodeParam;
			
			for (int size = size(listNodeParam), i = (n % size) + 1; i < size; i++)
				listNode = listNode.next;

			ListNode end = listNode;
			
			while (end.next != null)
				end = end.next;

			end.next = listNodeParam;
			listNodeParam = listNode.next;
			listNode.next = null;
		}
		return listNodeParam;
	}

	private static int size(ListNode listNodeStaticInt) {
		int result = 0;
		
		for (; listNodeStaticInt != null; listNodeStaticInt = listNodeStaticInt.next)
			result++;
		return result;
	}
}