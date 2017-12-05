package leetcode;

import model.TreeNode;

public class TrimABinarySearchTree {
  public TreeNode trimBST(TreeNode root, int L, int R) {
    if (null == root) {
      return null;
    }

    int val = root.val;

    if (val < L) {
      return trimBST(root.right, L, R);
    }
    if (val > R) {
      return trimBST(root.left, L, R);
    }

    TreeNode node = new TreeNode(val);
    node.left = trimBST(root.left, L, R);
    node.right = trimBST(root.right, L, R);


    return node;
  }
}
