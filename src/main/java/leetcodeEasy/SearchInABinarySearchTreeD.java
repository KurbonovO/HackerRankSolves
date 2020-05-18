package leetcodeEasy;

import util.TreeNode;

public class SearchInABinarySearchTreeD {

	public TreeNode searchBST(TreeNode root, int val) {
		while (root != null && root.root != val) {
			root = val < root.root ? root.left : root.right;
		}
		return root;
	}

}
