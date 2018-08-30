package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import model.TreeNode;

public class BinaryTreeRightSideView {

  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    if (root == null) {
      return list;
    }

    LinkedList<LinkedList<TreeNode>> queue = new LinkedList<>();

    LinkedList<TreeNode> queueRoot = new LinkedList<>();
    queueRoot.push(root);
    queue.add(queueRoot);

    while (!queue.isEmpty()) {
      LinkedList<TreeNode> tmp = queue.removeFirst();
      if (tmp.isEmpty()) {
        break;
      }
      LinkedList<TreeNode> ntmp = new LinkedList<>();

      Integer ret = 0;

      while (!tmp.isEmpty()) {
        TreeNode node = tmp.removeFirst();
        ret = node.val;

        if (node.left != null) {
          ntmp.add(node.left);
        }
        if (node.right != null) {
          ntmp.add(node.right);
        }
      }

      list.add(ret);

      queue.add(ntmp);
    }

    return list;
  }
}
