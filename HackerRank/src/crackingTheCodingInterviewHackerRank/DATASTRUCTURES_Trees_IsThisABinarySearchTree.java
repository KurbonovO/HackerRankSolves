//package crackingTheCodingInterviewHackerRank;
//
///*The data value of every node in a node's left subtree is less than the data value of that node.
//The data value of every node in a node's right subtree is greater than the data value of that node.
//
//Given the root node of a binary tree, can you determine if it's also a binary search tree?
//Complete the function in your editor below, which has 1 parameter: a pointer to the root of a binary tree. 
//It must return a boolean denoting whether or not the binary tree is a binary search tree. 
//You may have to write one or more helper functions to complete this challenge.
//Note: We do not consider a binary tree to be a binary search tree if it contains duplicate values. 
//*/
//
//boolean DATASTRUCTURES_Trees_IsThisABinarySearchTree(Node root, int minValue, int maxValue) {
//
//		if (root == null) {
//			return true;
//		}
//
//		if (root.data < minValue || root.data > maxValue) {
//			return false;
//		}
//
//		return (checkBST(root.left, minValue, root.data - 1) && checkBST(root.right, root.data + 1, maxValue));
//	}
//
//	DATASTRUCTURES_Trees_IsThisABinarySearchTree(Node root) {
//		return checkBST(root, 0, 10000);
//	}
//}