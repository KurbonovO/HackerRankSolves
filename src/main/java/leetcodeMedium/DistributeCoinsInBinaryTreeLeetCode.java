package leetcodeMedium;

import util.TreeNode;

public class DistributeCoinsInBinaryTreeLeetCode {

	public int distributeCoins(TreeNode treeNode) {
		
		int res = 0;
		
		if (treeNode.left != null) {
			
			res += distributeCoins(treeNode.left);
			treeNode.root += treeNode.left.root - 1;
			res += Math.abs(treeNode.left.root - 1);
		}
		
		if (treeNode.right != null) {
			
			res += distributeCoins(treeNode.right);
			treeNode.root += treeNode.right.root - 1;
			res += Math.abs(treeNode.right.root - 1);
		}
		return res;
	}

}
