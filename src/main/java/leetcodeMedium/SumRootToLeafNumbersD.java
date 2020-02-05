package leetcodeMedium;

import util.TreeNode;

public class SumRootToLeafNumbersD {

	public int sumNumbers(TreeNode root) {
		return sum(root, 0);
	}

	public int sum(TreeNode n, int s) {
		if (n == null)
			return 0;
		if (n.right == null && n.left == null)
			return s * 10 + n.root;
		return sum(n.left, s * 10 + n.root) + sum(n.right, s * 10 + n.root);
	}

}
