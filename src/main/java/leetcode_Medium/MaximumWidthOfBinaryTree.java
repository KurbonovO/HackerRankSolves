package leetcode_Medium;

import java.util.ArrayList;
import java.util.List;

import util.TreeNode;

/*662 Given a binary tree, write a function to get the maximum width of the
given tree. The width of a tree is the maximum width among all levels. The
binary tree has the same structure as a full binary tree, but some nodes are
null. The width of one level is defined as the length between the end-nodes
(the leftmost and right most non-null nodes in the level, where the null nodes
between the end-nodes are also counted into the length calculation.
Input:     1			Output: 4
         /   \
        3     2
       / \     \  
      5   3     9 


The maximum width existing in the third level with the length 4 (5,3,null,9)
Input:   1		Output: 2
         /  
        3    
       / \       
      5   3     
The maximum width existing in the third level with the length 2 (5,3).
Input:    1			Output: 2
         / \
        3   2 
       /        
      5      
The maximum width existing in the second level with the length 2 (3,2).

Input:    1		Output: 8
         / \
        3   2
       /     \  
      5       9 
     /         \
    6           7
The maximum width existing in the fourth level with the length 8 
(6,null,null,null,null,null,null,7)											 */

public class MaximumWidthOfBinaryTree {

	public int widthOfBinaryTree(TreeNode root) {
		return dfs(root, 0, 1, new ArrayList<Integer>(),
				new ArrayList<Integer>());
	}

	public int dfs(TreeNode root, int level, int order, 
			List<Integer> start, List<Integer> end) {

		if (root == null)
			return 0;

		if (start.size() == level) {
			start.add(order);
			end.add(order);
		} else {
			end.set(level, order);
		}
		int cur = end.get(level) - start.get(level) + 1;
		int left = dfs(root.left, level + 1, 2 * order, start, end);
		int right = dfs(root.right, level + 1, 2 * order + 1, start, end);
		return Math.max(cur, Math.max(left, right));
	}
}
