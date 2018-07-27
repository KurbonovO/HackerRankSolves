package leetcode_Medium;

import java.util.Stack;

import util.TreeNode;

/*230 Given a binary search tree, write a function kthSmallest to find the kth
smallest element in it.
Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2		Output: 1
Input: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1				Output: 3													 */

public class KthSmallestElementInABST {
	public int kthSmallest(TreeNode treeNodeInput, int intN) {

		Stack<TreeNode> stackTreeNode = new Stack<TreeNode>();
		TreeNode treeNodeFromInput = treeNodeInput;
		int count = 0;

		while (!stackTreeNode.isEmpty() || treeNodeFromInput != null) {
			
			if (treeNodeFromInput != null) {
				/* Just like recursion */
				stackTreeNode.push(treeNodeFromInput);
				treeNodeFromInput = treeNodeFromInput.left;

			} else {
				TreeNode node = stackTreeNode.pop();
				if (++count == intN)
					return node.val;
				treeNodeFromInput = node.right;
			}
		}
		return Integer.MIN_VALUE;
	}
}
