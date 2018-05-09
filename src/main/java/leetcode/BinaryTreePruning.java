package leetcode;

import model.TreeNode;

public class BinaryTreePruning {

  public TreeNode pruneTree(TreeNode root) {
    TreeNode fake = new TreeNode(-1);
    fake.left = root;
    prune(fake);
    return fake.left;
  }

  private boolean prune(TreeNode root) {
    if (root == null) {
      return true;
    }
    boolean left = prune(root.left);
    if (left) {
      root.left = null;
    }

    boolean right = prune(root.right);
    if (right) {
      root.right = null;
    }

    return root.val == 0 && left && right;
  }


}
