package leetcode_Hard;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import util.TreeNode;

/*145 Given a binary tree, return the postorder traversal of its nodes' values
Given binary tree [1,null,2,3],

   1
    \
     2
    /
   3            return [3,2,1]                                               */

public class BinaryTreePostorderTraversal {
	public List<Integer> preorderTraversal(TreeNode root) {
		
		List<Integer> result = new ArrayList<>();
		Deque<TreeNode> stack = new ArrayDeque<>();
		TreeNode treeNode = root;
		
		while (!stack.isEmpty() || treeNode != null) {
			
			if (treeNode != null) {
				stack.push(treeNode);
			 /* Add before going to children */
				result.add(treeNode.val); 
				treeNode = treeNode.left;
			} 
			else {
				TreeNode node = stack.pop();
				treeNode = node.right;
			}
		}
		return result;
	}
}
