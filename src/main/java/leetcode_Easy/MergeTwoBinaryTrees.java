package leetcode_Easy;

import util.TreeNode;

/*617 Given two binary trees and imagine that when you put one of them to cover
the other, some nodes of the two trees are overlapped while the others are not.
You need to merge them into a new binary tree. The merge rule is that if two
nodes overlap, then sum node values up as the new value of the merged node.
Otherwise, the NOT null node will be used as the node of new tree			 */

public class MergeTwoBinaryTrees {
	public TreeNode mergeTrees(TreeNode treeNodeOne, TreeNode treeNodeTwo) {
		
		if (treeNodeOne == null && treeNodeTwo == null)
			return null;
		else if (treeNodeOne == null)
			return treeNodeTwo;
		else if (treeNodeTwo == null)
			return treeNodeOne;
		
		TreeNode treeNode = new TreeNode(treeNodeOne.val + treeNodeTwo.val);
		treeNode.left = mergeTrees(treeNodeOne.left, treeNodeTwo.left);
		treeNode.right = mergeTrees(treeNodeOne.right, treeNodeTwo.right);
		
		return treeNode;
	}
}