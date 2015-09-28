package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LowestCommonAncestorofaBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (null == root || p == null || q == null) {
            return null;
        }
        List<TreeNode> pNodePath = new ArrayList<TreeNode>();
        List<TreeNode> qNodePath = new ArrayList<TreeNode>();
        findPath(root, p, pNodePath);
        findPath(root, q, qNodePath);
        pNodePath.add(root);
        qNodePath.add(root);
        Collections.reverse(qNodePath);
        Collections.reverse(pNodePath);
        int n = 1;
        int max = Math.min(pNodePath.size(), qNodePath.size());

        while (n < max) {
            if (pNodePath.get(n) != qNodePath.get(n)) {
                break;
            }
            n++;
        }

        return pNodePath.get(n - 1);
    }

    public boolean findPath(TreeNode parent, TreeNode target, List<TreeNode> list) {
        if (parent == null) {
            return false;
        }
        if (target == parent) {
            return true;
        }
        if (findPath(parent.left, target, list)) {
            list.add(parent.left);
            return true;
        } else if (findPath(parent.right, target, list)) {
            list.add(parent.right);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode r = new TreeNode(0);
        TreeNode r1 = new TreeNode(1);
        TreeNode r2 = new TreeNode(2);
        TreeNode r3 = new TreeNode(3);
        TreeNode r4 = new TreeNode(4);
        TreeNode r5 = new TreeNode(5);
        TreeNode r6 = new TreeNode(6);
        TreeNode r7 = new TreeNode(7);

        r5.right = r7;
        r5.left = r6;

        r.left = r1;
        r.right = r2;

        r1.left = r3;
        r2.left = r4;
        r2.right = r5;

        List<TreeNode> qNodePath = new ArrayList<TreeNode>();

        LowestCommonAncestorofaBinaryTree l = new LowestCommonAncestorofaBinaryTree();
//        l.findPath(r, r6, qNodePath);
//        for (TreeNode n : qNodePath) {
//            System.out.println(n.val);
//        }
        TreeNode n = l.lowestCommonAncestor(r, r6, r7);
        System.out.println(n.val);
    }

}
