package leetcode_Easy;

import util.TreeNode;

/*669 Given a binary search tree and the lowest and highest boundaries as L and
R, trim the tree so that all its elements lies in [L, R] (R >= L). You might
need to change the root of the tree, so the result should return the new root of
the trimmed binary search tree												 */

public class TrimABinarySearchTree {
	public TreeNode trimBST(TreeNode treeNode, int intL, int intR) {
		
		if (treeNode == null)
			return null;

		if (treeNode.value < intL)
			return trimBST(treeNode.right, intL, intR);
		if (treeNode.value > intR)
			return trimBST(treeNode.left, intL, intR);

		treeNode.left = trimBST(treeNode.left, intL, intR);
		treeNode.right = trimBST(treeNode.right, intL, intR);

		return treeNode;
	}
}

/*Input: 
 1
/ \
0   2

L = 1
R = 2
Output: 
1
  \
   2
Input: 
3
/ \
0   4
\
2
/
1

L = 1
R = 3
Output: 
  3
 / 
2   
/
1																			 */
