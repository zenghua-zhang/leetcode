package leetcode;

import model.TreeNode;

public class ValidateBinarySearchTree {
  public boolean isValidBST(TreeNode root) {
    return valide(root, null, null);
  }

  private boolean valide(TreeNode root, Integer low, Integer high) {
    if (null == root) {
      return true;
    }
    if (low != null && root.val <= low) {
      return false;
    }
    if (high != null && root.val >= high) {
      return false;
    }

    return valide(root.left, low, root.val) && valide(root.right, root.val, high);
  }
}
