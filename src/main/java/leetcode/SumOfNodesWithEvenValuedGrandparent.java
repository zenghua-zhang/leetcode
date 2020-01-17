package leetcode;

import java.util.LinkedList;
import model.TreeNode;

public class SumOfNodesWithEvenValuedGrandparent {

  private int sum;

  public int sumEvenGrandparent(TreeNode root) {
    sum = 0;

    dfs(root);

    return sum;
  }

  private void dfs(TreeNode node) {
    if (node == null) {
      return;
    }
    if ((node.val & 1) == 0) {
      dfs(node, 2);
    }
    dfs(node.left);
    dfs(node.right);
  }

  public void dfs(TreeNode node, int depth) {
    if (node == null) {
      return;
    }

    if (depth == 0) {
      sum += node.val;
      return;
    }

    dfs(node.left, depth - 1);
    dfs(node.right, depth - 1);
  }


}
