package leetcode;

import model.TreeNode;

public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        return helper(root, false);
    }

    private int helper(TreeNode root, boolean isleft) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return isleft ? root.val : 0;
        }
        return helper(root.left, true) + helper(root.right, false);
    }
}
