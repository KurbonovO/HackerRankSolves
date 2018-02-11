package hacker_rank_Thirty;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import util.TreeNode;

/*A level-order traversal, also known as a breadth-first search, visits each level
of a tree's nodes from left to right, top to bottom. You are given a pointer,
root, pointing to the root of a binary search tree. Complete the levelOrder function
provided in your editor so that it prints the level-order traversal of the binary
search tree																	  */

public class DayTwentythree {

	static Queue<TreeNode> queue = new LinkedList<TreeNode>();

	static void levelOrder(TreeNode root) {

		if (root != null) {
			queue.add(root);
		}

		while (!queue.isEmpty()) {
			TreeNode tree = queue.remove();
			System.out.print(tree.data + " ");

			if (tree.left != null) {
				queue.add(tree.left);
			}

			if (tree.right != null) {
				queue.add(tree.right);
			}
		}
	}

	public static TreeNode insert(TreeNode root, int data) {

		if (root == null) {
			return new TreeNode(data);
		} 
		else {
			TreeNode currentTreeNode;

			if (data <= root.data) {
				currentTreeNode = insert(root.left, data);
				root.left = currentTreeNode;
			} 
			else {
				currentTreeNode = insert(root.right, data);
				root.right = currentTreeNode;
			}
			return root;
		}
	}

	public static void main(String args[]) {

		Scanner scanner = new Scanner(System.in);

		int intT = scanner.nextInt();

		TreeNode root = null;

		while (intT-- > 0) {
			int data = scanner.nextInt();
			root = insert(root, data);
		}

		scanner.close();
		levelOrder(root);
	}
}
	
/*Sample Input:6
3
5
4
7
2
1
Sample Output: 3 2 5 1 4 7 
The input forms the following binary search tree: BST.jpg, We traverse each level
of the tree from the root downward, and we process the nodes at each level from
left to right. The resulting level-order traversal is 3 -> 2 -> 5 -> 1 -> 4 -> 7
and we print these data values as a single line of space-separated integers	  */
