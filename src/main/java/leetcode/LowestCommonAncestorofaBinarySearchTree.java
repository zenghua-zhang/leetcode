package leetcode;

public class LowestCommonAncestorofaBinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (null == root || p == null || q == null) {
            return null;
        }
        int rValue = root.val, pValue = p.val, qValue = q.val;

        if ((rValue < pValue && rValue > qValue) || (rValue > pValue && rValue < qValue) || rValue == pValue
                || rValue == qValue) {
            return root;
        }

        if (rValue > pValue && rValue > qValue) {
            return lowestCommonAncestor(root.left, q, p);
        } else {
            return lowestCommonAncestor(root.right, q, p);
        }
    }
}
