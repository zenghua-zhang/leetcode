package leetcode;

import model.TreeNode;

public class KthSmallestElementInBST {

  private int result = 0;

  private int count = 0;

  public int kthSmallest(TreeNode root, int k) {
    helper(root, k);
    return result;
  }

  private void helper(TreeNode root, int k) {
    if (null == root) {
      return;
    }
    helper(root.left, k);
    count++;
    if (count == k) {
      result = root.val;
      return;
    }
    helper(root.right, k);
  }
}
