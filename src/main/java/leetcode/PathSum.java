package leetcode;

import model.TreeNode;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        return hasSum(root, sum, 0);

    }

    private boolean hasSum(TreeNode node, int sum, int i) {
        if (node == null) {
            return false;
        }
        i += node.val;
        if (node.left == null && node.right == null) {
            return i == sum;
        }
        return hasSum(node.left, sum, i) || hasSum(node.right, sum, i);
    }
}
