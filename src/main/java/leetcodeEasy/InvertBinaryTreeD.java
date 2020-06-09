package leetcodeEasy;

import util.TreeNode;

public class InvertBinaryTreeD {

	public TreeNode invertTree(TreeNode root) {

		if (root == null) {
			return null;
		}

		final TreeNode left = root.left, right = root.right;
		root.left = invertTree(right);
		root.right = invertTree(left);
		return root;
	}

}
