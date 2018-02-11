package leetcode;

import java.util.PriorityQueue;
import java.util.Queue;
import model.TreeNode;

public class MinimumDistanceBetweenBSTNodes {

  public int minDiffInBST(TreeNode root) {
    Queue<Integer> queue = new PriorityQueue<>();
    helper(root, queue);

    int tmp = queue.poll();
    int min = Integer.MAX_VALUE;
    while (!queue.isEmpty()) {
      int t = queue.poll();
      min = Math.min(min, Math.abs(t - tmp));
      tmp = t;
    }

    return min;

  }

  private void helper(TreeNode root, Queue<Integer> queue) {
    if (null == root) {
      return;
    }

    helper(root.left, queue);
    queue.add(root.val);
    helper(root.right, queue);
  }
}
