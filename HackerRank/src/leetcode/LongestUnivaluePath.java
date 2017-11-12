package leetcode;

/*687 Given a binary tree, find the length of the longest path where each node in the path has the same value.
This path may or may not pass through the root. Note: The length of path between two nodes is represented by
the number of edges between them. Input:
              5									
             / \						
            4   5						
           / \   \							
          1   1   5  Output: 2					

Input:
              1
             / \
            4   5
           / \   \
          4   4   5  Output: 2
Longest-Univalue-Path of a tree is among those Longest-Univalue-Path-Across at each node;
Longest-Univalue-Path-Across a node is sum of { Longest-Univalue-Path-Start-At each child with same value, + 1}*/

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) {val = x;}
}

public class LongestUnivaluePath {

	public int longestUnivaluePath(TreeNode root) {
		int[] res = new int[1];
		if (root != null)
			dfs(root, res);
		return res[0];
	}

	private int dfs(TreeNode node, int[] res) {
		
		int l = node.left != null ? dfs(node.left, res) : 0;
		
		int r = node.right != null ? dfs(node.right, res) : 0;
		
		int resl = node.left != null && node.left.val == node.val ? l + 1 : 0;
		
		int resr = node.right != null && node.right.val == node.val ? r + 1 : 0;
		
		res[0] = Math.max(res[0], resl + resr);
		
		return Math.max(resl, resr);
	}
}