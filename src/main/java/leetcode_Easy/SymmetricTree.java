package leetcode_Easy;

import util.TreeNode;

/*101 Given a binary tree, check whether it is a mirror of itself (ie,
symmetric around its center). For example, this binary tree
[1,2,2,3,4,4,3] is symmetric:
    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3																	 */

public class SymmetricTree {

	public boolean isSymmetric(TreeNode treeNode) {
		return treeNode == null || isSymmetricHelp(treeNode.left, treeNode.right);
	}

	private boolean isSymmetricHelp(TreeNode treeNodeLeft, TreeNode treeNodeRight) {

		if (treeNodeLeft == null || treeNodeRight == null) {
			return treeNodeLeft == treeNodeRight;
		}

		if (treeNodeLeft.value != treeNodeRight.value) {
			return false;
		}
		return isSymmetricHelp(treeNodeLeft.left, treeNodeRight.right)
				&& isSymmetricHelp(treeNodeLeft.right, treeNodeRight.left);
	}
}
