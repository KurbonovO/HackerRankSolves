package leetcode_Medium;

import java.util.LinkedList;
import java.util.List;

import util.TreeNode;

public class PathSumII {

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		List<Integer> currentResult = new LinkedList<Integer>();
		pathSum(root, sum, currentResult, result);
		return result;
	}

	public void pathSum(TreeNode root, int sum, List<Integer> currentResult, List<List<Integer>> result) {

		if (root == null)
			return;
		currentResult.add(new Integer(root.root));
		if (root.left == null && root.right == null && sum == root.root) {
			result.add(new LinkedList<Integer>(currentResult));
			// don't forget to remove the last integer
			currentResult.remove(currentResult.size() - 1);
			return;
		} else {
			pathSum(root.left, sum - root.root, currentResult, result);
			pathSum(root.right, sum - root.root, currentResult, result);
		}
		currentResult.remove(currentResult.size() - 1);
	}

}
