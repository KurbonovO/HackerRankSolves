package leetcodeMedium;

import util.TreeNode;

public class ValidateBinarySearchTreeD {

	public boolean isValidBST(TreeNode root) {

		return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
		if (root == null)
			return true;
		if (root.root >= maxVal || root.root <= minVal)
			return false;
		return isValidBST(root.left, minVal, root.root) && isValidBST(root.right, root.root, maxVal);
	}

}
