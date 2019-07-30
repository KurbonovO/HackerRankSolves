package leetcodeEasy;

import util.TreeNode;

public class ConvertSortedArrayToBinarySearchTreeBeck {

	public static TreeNode arrToTreeLeetCode(int[] arr) {

		TreeNode head = helper(arr, 0, arr.length - 1);
		return head;
	}

	public static TreeNode helper(int[] arr, int low, int high) {

		if (low > high) {

			return null;
		}
		int mid = low + (high - low) / 2;

		TreeNode node = new TreeNode(arr[mid]);
		node.left = helper(arr, low, mid - 1);
		node.right = helper(arr, mid + 1, high);
		return node;
	}

	public static void main(String[] args) {

		int[] arr = { -10, -3, 0, 5, 9 };

		System.out.println(ConvertSortedArrayToBinarySearchTreeBeck.arrToTreeLeetCode(arr));
	}
}
