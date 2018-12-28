package leetcode_Easy;

import util.TreeNode;

/*530 Given a binary search tree with non-negative values, find the minimum
absolute difference between values of any two nodes.
Input:
   1
    \
     3
    /
   2	Output: 1
The minimum absolute difference is 1, which is the difference between 2 and 1
(or between 2 and 3)														 */

public class MinimumAbsoluteDifferenceInBST {

	int min = Integer.MAX_VALUE;
	Integer prev = null;

	public int getMinimumDifference(TreeNode root) {

		if (root == null) {
			return min;
		}

		getMinimumDifference(root.left);

		if (prev != null) {
			min = Math.min(min, root.value - prev);
		}
		prev = root.value;

		getMinimumDifference(root.right);

		return min;
	}
}
