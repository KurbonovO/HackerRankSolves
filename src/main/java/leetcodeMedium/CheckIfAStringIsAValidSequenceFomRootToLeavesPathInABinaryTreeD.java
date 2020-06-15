package leetcodeMedium;

import util.TreeNode;

public class CheckIfAStringIsAValidSequenceFomRootToLeavesPathInABinaryTreeD {

	public boolean isValidSequence(TreeNode root, int[] arr) {
		return isValid(root, arr, 0);
	}

	private boolean isValid(TreeNode node, int[] arr, int curr) {
		// We should not be reaching null here because we must return from leaf node.
		if (node == null)
			return false;
		// Leaf node should be the last node in the array.
		if (curr == arr.length - 1) {
			return node.left == null && node.right == null && arr[curr] == node.root;
		}
		// This node has to be same as the current value.
		if (node.root != arr[curr])
			return false;
		boolean left = isValid(node.left, arr, curr + 1);
		boolean right = isValid(node.right, arr, curr + 1);
		return left || right;
	}

}
