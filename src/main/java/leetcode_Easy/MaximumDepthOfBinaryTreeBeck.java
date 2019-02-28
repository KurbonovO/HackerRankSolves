package leetcode_Easy;

import linkedList.Node;

public class MaximumDepthOfBinaryTreeBeck {
	public int maximumDepthOfBinaryTreeBeck(Node node) {

		if (node == null) {
			return 0;
		}

		int i = Math.max(maximumDepthOfBinaryTreeBeck(node.next), maximumDepthOfBinaryTreeBeck(node.previous));
		i = i + 1;
		return i;
	}

	public static void main(String[] args) {

	}

}
