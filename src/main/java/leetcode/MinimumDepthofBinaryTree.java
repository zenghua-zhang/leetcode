package leetcode;

import model.TreeNode;

public class MinimumDepthofBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return min(root, 1, Integer.MAX_VALUE);

    }

    private int min(TreeNode root, int depth, int min) {
        if (root.left == null & root.right == null) {
            min = Math.min(depth, min);
        } else {
            if (root.left != null) {
                min = Math.min(min, min(root.left, depth + 1, min));
            }
            if (root.right != null) {
                min = Math.min(min, min(root.right, depth + 1, min));
            }
        }
        return min;
    }
}
