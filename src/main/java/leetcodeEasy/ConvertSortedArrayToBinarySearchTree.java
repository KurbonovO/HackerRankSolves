package leetcodeEasy;

import util.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {

    public TreeNode sortedarrayToBST(int[] nums) {

        if (nums == null || nums.length == 0) {

            return null;
        }
        TreeNode resultTreeNode = helper(nums, 0, nums.length - 1);
        return resultTreeNode;
    }

    public TreeNode helper(int[] nums, int low, int high) {

        //Done
        if (low > high) {
            return null;
        }

        int mid = (low + high) / 2;

        TreeNode result = new TreeNode(nums[mid]);

        result.left = helper(nums, low, mid - 1);
        result.right = helper(nums, mid + 1, high);
        return result;
    }


}
