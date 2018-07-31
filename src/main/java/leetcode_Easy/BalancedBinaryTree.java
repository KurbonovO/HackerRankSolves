package leetcode_Easy;

import util.TreeNode;

/*110 Given a binary tree, determine if it is height-balanced. For this problem
a height-balanced binary tree is defined as: a binary tree in which the depth
of the two subtrees of every node never differ by more than 1.
Given the following tree [3,9,20,null,null,15,7]:			Return true
    3
   / \
  9  20
    /  \
   15   7
Given the following tree [1,2,2,3,3,null,null,4,4]:			Return false
       1
      / \
     2   2
    / \
   3   3
  / \
 4   4																		 */

public class BalancedBinaryTree {
	public boolean isBalanced(TreeNode treeNode) {
		return dfsHeight(treeNode) != -1;
	}

	private int dfsHeight(TreeNode treeNode) {
		if (treeNode == null) {
			return 0;
		}

		int leftHeight = dfsHeight(treeNode.left);
		if (leftHeight == -1) {
			return -1;
		}

		int rightHeight = dfsHeight(treeNode.right);
		if (rightHeight == -1) {
			return -1;
		}

		if (Math.abs(leftHeight - rightHeight) > 1) {
			return -1;
		}

		return Math.max(leftHeight, rightHeight) + 1;
	}
}
