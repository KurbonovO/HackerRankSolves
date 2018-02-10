package hacker_rank_Thirty;

import java.util.Scanner;

import util.ListNode;
import util.TreeNode;

/*The height of a binary search tree is the number of edges between the tree's
root and its furthest leaf. You are given a pointer, root, pointing to the root
of a binary search tree. Complete the getHeight function provided in your editor
so that it returns the height of the binary search tree						  */

public class DayTwentytwo {

	public static int getHeight(TreeNode root){
	   
		if (root == null){
	        return -1;
	    }
	    else{
	        return 1 + Math.max( getHeight(root.left), getHeight(root.right) );
	    }
	}

	public static TreeNode insert(TreeNode root, int data) {
		
		if (root == null) {
			return new TreeNode(data);
		} 
		else {
			TreeNode cur;
			
			if (data <= root.data) {
				cur = insert(root.left, data);
				root.left = cur;
			} 
			else {
				cur = insert(root.right, data);
				root.right = cur;
			}
			return root;
		}
	}
	
	public static void main(String args[]) {
		
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		TreeNode root = null;
		
		while (T-- > 0) {
			int data = scanner.nextInt();
			root = insert(root, data);
		}
		
		int height = getHeight(root);
		System.out.println(height);
		
		scanner.close();
	}
}

/*Sample Input:7
3
5
2
1
4
6
7
Sample Output: 3															  */
