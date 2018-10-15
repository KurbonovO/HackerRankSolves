package leetcode_Medium;

import util.ListNode;
import util.TreeNode;

/*109 Given a singly linked list where elements are sorted in ascending order,
convert it to a height balanced BST. For this problem, a height-balanced binary
tree is defined as a binary tree in which the depth of the two subtrees of
every node never differ by more than 1. Given the sorted linked list:
[-10,-3,0,5,9], One possible answer is: [0,-3,9,-10,null,5], which represents
the following height balanced BST:
      0
     / \
   -3   9
   /   /
 -10  5																		 */

public class SortedListToBinarySearchTree {

	public TreeNode sortedListToBST(ListNode listNodeHead) {
		if (listNodeHead == null)
			return null;
		return toBST(listNodeHead, null);
	}

	public TreeNode toBST(ListNode listNodeHead, ListNode lListNodeTail) {

		ListNode slow = listNodeHead;
		ListNode fast = listNodeHead;

		if (listNodeHead == lListNodeTail) {
			return null;
		}

		while (fast != lListNodeTail && fast.next != lListNodeTail) {
			fast = fast.next.next;
			slow = slow.next;
		}

		TreeNode thead = new TreeNode(slow.val);
		thead.left = toBST(listNodeHead, slow);
		thead.right = toBST(slow.next, lListNodeTail);
		return thead;
	}
}
