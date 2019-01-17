package leetcode_Easy;

import util.TreeNode;

public class UnivaluedBinaryTreeLeetCode {
	public boolean isUnivalTree(TreeNode treeNode) {

		if (treeNode == null) {
			return false;
		}

		/*We are checking if left is not null and if left node is not equal to the
		  root */
		if (treeNode.left != null && treeNode.left.root != treeNode.root) {

			return false;
		}

		/*We are checking if right is not null and if right node is not equal to the
		  root */
		if (treeNode.right != null && treeNode.right.root != treeNode.root) {

			return false;
		}
		return isUnivalTree(treeNode.left) && isUnivalTree(treeNode.right);
	}
}
