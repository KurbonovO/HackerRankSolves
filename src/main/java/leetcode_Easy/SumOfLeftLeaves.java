package leetcode_Easy;

import util.TreeNode;

/*404 Find the sum of all left leaves in a given binary tree
    3
   / \
  9  20
    /  \
   15   7
There are two left leaves in the binary tree, with values 9 and 15 respectively
Return 24																	 */

public class SumOfLeftLeaves {
	
	int sum;

	public int sumOfLeftLeaves(TreeNode treeNode) {
		sum = 0;
		
	 /* false means the next node is not in the left side */
		inOrder(treeNode, false); 

		return sum;
	}

	private void inOrder(TreeNode root, boolean left) {
		if (root == null) {
			return;
		}

	 /* true means the next node is in the left side */
		inOrder(root.left, true);
		
	 /* only left leaves can be added to result */
		if (root.left == null && root.right == null && left) { 
			sum += root.value;
		}
		inOrder(root.right, false);
	}
}
