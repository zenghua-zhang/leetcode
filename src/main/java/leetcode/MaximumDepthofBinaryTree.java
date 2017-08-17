package leetcode;

import model.TreeNode;

public class MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }

}
