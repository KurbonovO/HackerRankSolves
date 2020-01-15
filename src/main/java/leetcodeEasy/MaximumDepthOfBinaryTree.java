package leetcodeEasy;

import util.TreeNode;

public class MaximumDepthOfBinaryTree {

    public static int count = 0;

    public static int maxDepth(TreeNode root) {

        if (root.left != null) {

            count++;
            maxDepth(root.left);

        } else if (root.right != null) {

            count++;
            maxDepth(root.right);
        }
        return count;
    }

    public static int maxDepthLeetCode(TreeNode treeNode) {

        if(treeNode == null) {

            return -1;
        }
        int leftMax = treeNode.left == null ? 0 : maxDepth(treeNode.left);
        int rightMax = treeNode.right == null ? 0 : maxDepth(treeNode.right);

        return 1 + Math.max(leftMax, rightMax);
    }
}
