package leetcodeMedium;

import util.TreeNode;

public class MaximumBinaryTreeIID {

	public TreeNode insertIntoMaxTree(TreeNode root, int val) {
		if (root != null && root.root > val) {
			root.right = insertIntoMaxTree(root.right, val);
			return root;
		}
		TreeNode node = new TreeNode(val);
		node.left = root;
		return node;
	}

}
