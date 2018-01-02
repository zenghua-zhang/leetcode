package leetcode;

import model.TreeNode;

public class AddOneRowToTree {

  public TreeNode addOneRow(TreeNode root, int v, int d) {
    if (d <= 0) {
      return root;
    }
    if (d == 1) {
      TreeNode node = new TreeNode(v);
      node.left = root;
      return node;
    }

    helper(root, v, d, 1);

    return root;

  }

  private void helper(TreeNode root, int v, int d, int row) {
    if (root == null) {
      return;
    }
    if (row + 1 == d) {
      TreeNode left = new TreeNode(v);
      TreeNode right = new TreeNode(v);
      left.left = root.left;
      right.right = root.right;
      root.left = left;
      root.right = right;
      return;
    }
    helper(root.left, v, d, row + 1);
    helper(root.right, v, d, row + 1);
  }
}
