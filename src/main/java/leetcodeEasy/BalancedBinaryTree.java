package leetcodeEasy;

import util.TreeNode;

public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {

        return helper(root) != -1;
    }

    public int helper(TreeNode root) {

        int left = helper(root.left);
        int right = helper(root.right);
        return Math.max(left, right) + 1;
    }
}
