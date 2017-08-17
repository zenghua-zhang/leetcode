package leetcode;

import model.TreeNode;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if ((q == null && p != null) || (q != null && p == null)) {
            return false;
        }
        if (q != null && p != null && q.val != p.val) {
            return false ;
        }

        boolean ret = true;
        ret = ret && isSameTree(p.left, q.left);
        ret = ret && isSameTree(p.right, q.right);

        return ret;
    }
}
