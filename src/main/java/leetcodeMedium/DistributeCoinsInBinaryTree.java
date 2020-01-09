package leetcodeMedium;

import util.TreeNode;

public class DistributeCoinsInBinaryTree {

	int res = 0;

	public int distributeCoins(TreeNode root) {
		dfs(root);
		return res;
	}

	public int dfs(TreeNode root) {
		if (root == null)
			return 0;
		int left = dfs(root.left), right = dfs(root.right);
		res += Math.abs(left) + Math.abs(right);
		return root.root + left + right - 1;
	}

}
