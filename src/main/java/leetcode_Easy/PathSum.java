package leetcode_Easy;

import util.TreeNode;

/*112 Given a binary tree and a sum, determine if the tree has a root-to-leaf
path such that adding up all the values along the path equals the given sum.
Given the below binary tree and sum = 22,	    	 5
     										        / \
                                                   4   8
                                                  /   / \
                                                 11  13  4
                                                /  \      \
                                               7    2      1				 
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22  */

public class PathSum {
	public boolean hasPathSum(int intKInput, TreeNode treeNodeInput) {

		if (treeNodeInput == null) {
			return false;
		}

		if (treeNodeInput.left == null && treeNodeInput.right == null) {
			return intKInput == treeNodeInput.value;
		}

		return hasPathSum(intKInput - treeNodeInput.value, treeNodeInput.left)
				|| hasPathSum(intKInput - treeNodeInput.value, treeNodeInput.right);
	}
}
