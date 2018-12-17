package leetcode;

import java.util.LinkedList;
import model.TreeNode;

public class CheckCompletenessOfBinaryTree {

  public boolean isCompleteTree(TreeNode root) {
    if (root == null) {
      return false;
    }
    LinkedList<TreeNode> queue = new LinkedList<>();
    boolean metNull = false;
    queue.add(root);

    while (!queue.isEmpty()) {
      TreeNode n = queue.removeFirst();
      if (null == n) {
        metNull = true;
        continue;
      }
      if (metNull) {
        return false;
      }
      queue.add(n.left);
      queue.add(n.right);
    }
    return true;
  }
}
