package leetcodeEasy;

import util.TreeNode;

public class MaximumDepthOfBinaryTreeBeck {

	public static int maxDepthBeck(TreeNode treeNode) {

		if (treeNode.left == null || treeNode.right == null) {

			return -1;
		}

		int counter = 0;

		if (treeNode.left != null || treeNode.right != null) {

			counter++;
			maxDepthBeck(treeNode);
		}
		return counter;
	}

	public static int maxDepthLeetCode(TreeNode treeNode) {

		if (treeNode == null) {

			return -1;
		}

		int leftMax = treeNode.left == null ? 0 : maxDepthLeetCode(treeNode.left);
		int rightMax = treeNode.right == null ? 0 : maxDepthLeetCode(treeNode.right);

		return Math.max(leftMax, rightMax) + 1;
	}

	public static void main(String[] args) {

	}

}
