package leetcodeEasy;

import util.TreeNode;

public class UnivaluedBinaryTreeLeetCode {

	public boolean isUnivalTree(TreeNode root) {
		if (root.left != null) {
			if (!isUnivalTree(root.left))
				return false;
			if (root.left.root != root.root)
				return false;
		}

		if (root.right != null) {
			if (!isUnivalTree(root.right))
				return false;
			if (root.right.root != root.root)
				return false;
		}
		return true;
	}

}
