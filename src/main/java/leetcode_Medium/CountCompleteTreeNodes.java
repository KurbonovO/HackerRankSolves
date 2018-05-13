package leetcode_Medium;

import util.TreeNode;

/*222 Given a complete binary tree, count the number of nodes. In a complete
binary tree every level, except possibly the last, is completely filled, and all
nodes in the last level are as far left as possible. It can have between 1 and
2h nodes inclusive at the last level h										 */

public class CountCompleteTreeNodes {
	public int countNodes(TreeNode treeNode) {
		
		if (treeNode == null)
			return 0;

		int left = getHeightLeft(treeNode);
		int right = getHeightRight(treeNode);

		/* If left and right are equal it means that the tree is complete and
		  hence go for 2^h -1. 												 */
		if (left == right)
			return ((2 << (left)) - 1);

		/* else recursively calculate the number of nodes in left and right and
		   add 1 for root. 													 */
		else
			return countNodes(treeNode.left) + countNodes(treeNode.right) + 1;
	}

	public int getHeightLeft(TreeNode treeNode) {
		
		int count = 0;
		
		while (treeNode.left != null) {
			count++;
			treeNode = treeNode.left;
		}
		return count;
	}

	public int getHeightRight(TreeNode treeNode) {
		
		int count = 0;
		
		while (treeNode.right != null) {
			count++;
			treeNode = treeNode.right;
		}
		return count;
	}
}

/*Input: 					Output: 6
    1
   / \
  2   3
 / \  /
4  5 6																		 */
