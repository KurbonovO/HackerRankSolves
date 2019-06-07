package leetcode_Easy;

import util.TreeNode;

public class SecondMinimumNodeInABinaryTree {
	
	public int findSecondMinimumValue(TreeNode treeNode) {

		if (treeNode == null) {
			return -1;
		}

		if (treeNode.left == null && treeNode.right == null) {
			return -1;
		}

		int left = treeNode.left.root;
		int right = treeNode.right.root;

		// if value same as root value, need to find the next candidate
		if (treeNode.left.root == treeNode.root) {
			
			left = findSecondMinimumValue(treeNode.left);
		}
		if (treeNode.right.root == treeNode.root) {
			
			right = findSecondMinimumValue(treeNode.right);
		}

		if (left != -1 && right != -1) {
			
			return Math.min(left, right);
		} else if (left != -1) {
			
			return left;
		} else {
			
			return right;
		}
	}
	
}
