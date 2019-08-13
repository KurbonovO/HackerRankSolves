package leetcodeEasy;

import util.TreeNode;

public class SameTreeBeck {

	public static Boolean isSameTreeLeetCode(TreeNode p, TreeNode q) {

		if (p == null && q == null) {
			return true;
		}
		if (p == null || q == null) {
			return false;
		}
		if (p.root == q.root) {

			return isSameTreeLeetCode(p.left, q.left) && isSameTreeLeetCode(p.right, q.right);

		} else {

			return false;
		}
	}
}
