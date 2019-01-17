package leetcode_Easy;

import util.TreeNode;

public class MergeTwoBinaryTreesBeck {
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

		if (t1 == null || t2 == null) {
			return null;
		}

		if (t1 == null) {
			return t2;
		} else if (t2 == null) {
			return t1;
		}
		TreeNode result = new TreeNode(t1.root + t2.root);

		result.left = mergeTrees(t1.left, t2.left);
		result.right = mergeTrees(t1.right, t2.right);

		return result;
	}
}
