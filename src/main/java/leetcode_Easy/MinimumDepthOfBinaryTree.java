package leetcode_Easy;

import util.TreeNode;

/*111 
Given a binary tree, find its minimum depth. The minimum depth is the number of
nodes along the shortest path from the root node down to the nearest leaf node.
Note: A leaf is a node with no children.
  3
 / \
9  20
  /  \
 15   7						return its minimum depth = 2				     */

public class MinimumDepthOfBinaryTree {

	public int minDepth(TreeNode treeNode) {
		
		if (treeNode == null)
			return 0;
		
		int left = minDepth(treeNode.left);
		int right = minDepth(treeNode.right);
		
		return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
	}
}
