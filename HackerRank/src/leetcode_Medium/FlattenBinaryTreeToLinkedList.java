package leetcode_Medium;

import javax.swing.tree.TreeNode;

/*Given a binary tree, flatten it to a linked list in-place.
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6						*/

public class FlattenBinaryTreeToLinkedList {
	
	public void flatten(TreeNode root) {
	    flatten(root,null);
	}
	
	private TreeNode flatten(TreeNode root, TreeNode pre) {
	    if(root==null) return pre;
	    pre=flatten(root.right,pre);    
	    pre=flatten(root.left,pre);
	    root.right=pre;
	    root.left=null;
	    pre=root;
	    return pre;
	}
}