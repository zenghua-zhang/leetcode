package leetcode;

import model.TreeNode;

public class MaximumBinaryTree {

  public TreeNode constructMaximumBinaryTree(int[] nums) {
    if (nums.length == 0) {
      return null;
    }

    return helper(nums, 0, nums.length - 1);
  }

  private TreeNode helper(int[] nums, int start, int end) {
    if (start > end) {
      return null;
    }
    if (start == end) {
      return new TreeNode(nums[start]);
    }

    int max = Integer.MIN_VALUE;
    int pos = -1;

    for (int i = start; i <= end; i++) {
      if (nums[i] > max) {
        max = nums[i];
        pos = i;
      }
    }

    TreeNode root = new TreeNode(nums[pos]);
    root.left = helper(nums, start, pos - 1);
    root.right = helper(nums, pos + 1, end);

    return root;
  }
}
