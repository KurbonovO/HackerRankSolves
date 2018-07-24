package leetcode_Easy;

import util.TreeNode;

/*108 Given an array where elements are sorted in ascending order, convert it
to a height balanced BST. For this problem, a height-balanced binary tree is
defined as a binary tree in which the depth of the two subtrees of every node
never differ by more than 1.
Given the sorted array: [-10,-3,0,5,9], One possible answer is:
[0,-3,9,-10,null,5], which represents the following height balanced BST:
                       0
                      / \
                    -3   9
                    /   /
                   -10  5													 */

public class ConvertSortedArrayToBinarySearchTree {
	public TreeNode sortedArrayToBST(int[] num) {

		if (num.length == 0) {
			return null;
		}
		TreeNode head = helper(num, 0, num.length - 1);
		return head;
	}

	public TreeNode helper(int[] num, int low, int high) {

		/* Done */
		if (low > high) { 
			return null;
		}

		int mid = low + (high - low) / 2;
		TreeNode treeNode = new TreeNode(num[mid]);
		treeNode.left = helper(num, low, mid - 1);
		treeNode.right = helper(num, mid + 1, high);
		return treeNode;
	}
}
