package leetcodeEasy;

import util.TreeNode;

public class MaximumDepthOfBinaryTreeBeck {

	public static int maxDepthBeck(TreeNode root) {

		int countLeft = 1;
		int countRight = 1;

		while (root != null) {

			if (root.left != null) {

				countLeft++;
			}
			if (root.right != null) {

				countRight++;
			}
		}
		return Math.max(countLeft, countRight);
	}

	public static int maxDepthLeetCode(TreeNode root) {

		if (root == null) {
			return -1;
		}
		int counter = Math.max(maxDepthLeetCode(root.left), maxDepthBeck(root.right));
		int result = counter + 1;
		return result;
	}
}
