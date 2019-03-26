package leetcode_Medium;

import util.TreeNode;

public class BinaryTreePruning {
	public TreeNode pruneTree(TreeNode root) {
		if (root == null)
			return null;
		root.left = pruneTree(root.left);
		root.right = pruneTree(root.right);
		if (root.left == null && root.right == null && root.root == 0)
			return null;
		return root;
	}
}
