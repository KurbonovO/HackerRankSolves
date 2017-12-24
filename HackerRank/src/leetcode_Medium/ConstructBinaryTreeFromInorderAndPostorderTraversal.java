package leetcode_Medium;

import util.TreeNode;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
	
	int pInorder;   // index of inorder array
	int pPostorder; // index of postorder array

	private TreeNode buildTree(int[] inorder, int[] postorder, TreeNode end) {
		if (pPostorder < 0) {
			return null;
		}
		
	  //create root node
		TreeNode n = new TreeNode(postorder[pPostorder--]);
		
	  //if right node exist, create right subtree
		if (inorder[pInorder] != n.val) {
			n.right = buildTree(inorder, postorder, n);
		}
		
		pInorder--;
		
	  //if left node exist, create left subtree
		if ((end == null) || (inorder[pInorder] != end.val)) {
			n.left = buildTree(inorder, postorder, end);
		}
		return n;
	}

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		
		pInorder = inorder.length - 1;
		pPostorder = postorder.length - 1;
		
		return buildTree(inorder, postorder, null);
	}
}