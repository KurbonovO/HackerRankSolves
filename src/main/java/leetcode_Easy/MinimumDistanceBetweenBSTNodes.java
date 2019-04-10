package leetcode_Easy;

import java.util.Stack;

import util.TreeNode;

public class MinimumDistanceBetweenBSTNodes {
	public int minDiffInBST(TreeNode node) {
		int diff = Integer.MAX_VALUE;
		if (node == null)
			return diff;
		Stack<TreeNode> stk = new Stack<TreeNode>();
		TreeNode prev = null;
		while (!stk.isEmpty() || node != null) {
			while (node != null) {
				stk.push(node);
				node = node.left;
			}
			TreeNode popped = stk.pop();
			if (prev != null) {
				diff = Math.min(diff, popped.root - prev.root);
			}
			prev = popped;
			node = popped.right;
		}
		return diff;

	}
}
