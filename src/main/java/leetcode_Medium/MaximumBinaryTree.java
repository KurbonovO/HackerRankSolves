package leetcode_Medium;

import java.util.Deque;
import java.util.LinkedList;

import util.TreeNode;

/*654 Given an integer array with no duplicates. A maximum tree building on
this array is defined as follow:
The root is the maximum number in the array.
The left subtree is the maximum tree constructed from left part subarray
divided by the maximum number.
The right subtree is the maximum tree constructed from right part subarray
divided by the maximum number.
Construct the maximum tree by the given array and output the root node of this
tree																		 */

public class MaximumBinaryTree {
	public TreeNode constructMaximumBinaryTree(int[] intArrayInput) {
		
		Deque<TreeNode> stack = new LinkedList<>();
		
		for (int i = 0; i < intArrayInput.length; i++) {
			TreeNode curr = new TreeNode(intArrayInput[i]);
			
			while (!stack.isEmpty() && stack.peek().val < intArrayInput[i]) {
				curr.left = stack.pop();
			}
			
			if (!stack.isEmpty()) {
				stack.peek().right = curr;
			}
			stack.push(curr);
		}
		return stack.isEmpty() ? null : stack.removeLast();
	}
}

/*Input: [3,2,1,6,0,5] 
Output: return the tree root node representing the following tree:
      6
    /   \
   3     5
    \    / 
     2  0   
       \
        1																	 */
