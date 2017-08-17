package leetcode;

import model.TreeNode;

public class MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (null == t1 && null == t2) {
            return null;
        }

        int val1 = 0, val2 = 0;
        TreeNode left1 = null, right1 = null, left2 = null, right2 = null;
        if (null != t1) {
            val1 = t1.val;
            left1 = t1.left;
            right1 = t1.right;
        }
        if (null != t2) {
            val2 = t2.val;
            left2 = t2.left;
            right2 = t2.right;
        }

        TreeNode newNode = new TreeNode(val1 + val2);
        newNode.left = mergeTrees(left1, left2);
        newNode.right = mergeTrees(right1, right2);
        return newNode;
    }
}
