package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import model.TreeNode;

public class FindLargestValueinEachTreeRow {

  public List<Integer> largestValues(TreeNode root) {
    List<Integer> ret = new ArrayList<>();
    if (null == root) {
      return ret;
    }

    LinkedList<TreeNode> row = new LinkedList<>();
    LinkedList<TreeNode> tmpNodes = new LinkedList<>();

    row.add(root);
    while (!row.isEmpty()) {
      int maxOfRow = Integer.MIN_VALUE;
      while (!row.isEmpty()) {
        TreeNode node = row.removeLast();
        maxOfRow = Math.max(maxOfRow, node.val);
        if (node.left != null) {
          tmpNodes.add(node.left);
        }
        if (node.right != null) {
          tmpNodes.add(node.right);
        }
      }
      ret.add(maxOfRow);

      row.addAll(tmpNodes);
      tmpNodes.clear();
    }

    return ret;
  }
}
