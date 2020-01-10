package leetcodeEasy;

import util.TreeNode;

public class MergeTwoBinaryTrees {

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        //We are first checking if they are null
        if (t1 == null && t2 == null) {

            return null;

        } else if (t1 == null) {

            return t2;

        } else if (t2 == null) {

            return t1;
        }

        //Getting the tip top value of it along with the null check as well;
        int val = (t1 == null ? 0 : t1.root) + (t2 == null ? 0 : t2.root);

        //We create a new TreeNode with the top value we got
        TreeNode newNode = new TreeNode(val);

        newNode.left = mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
        newNode.right = mergeTrees(t2 == null ? null : t2.right, t2 == null ? null : t2.right);

        return newNode;
    }
}
