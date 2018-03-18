package leetcode_Easy;

import util.TreeNode;

/*117 Follow up for problem "Populating Next Right Pointers in Each Node". What
if the given tree could be any binary tree? Would your previous solution still 
work? You may only use constant extra space.
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL														  */

public class LowestCommonAncestorOfABinarySearchTree {
	public void connect(TreeNode treeNode) {
        
	  //The left most node in the lower level
		TreeNode head = treeNode;
	  //The previous node in the lower level
		TreeNode prev = null;
	  //The current node in the upper level
		TreeNode curr = null;
        
		while (head != null){
            curr = head;
            prev = null;
            head = null;
            
            while (curr != null){
                
            	if (curr.left != null){
                    
            		if (prev != null)
                        prev.next=curr.left;
                    
            		else 
                        head = curr.left;
                    prev = curr.left;
                }
                
            	if (curr.right != null){
                    
            		if (prev != null)
                        prev.next = curr.right;
                    
            		else 
                        head = curr.right;
                    prev = curr.right;
                }
                curr = curr.next;
            }
        }
    }
}