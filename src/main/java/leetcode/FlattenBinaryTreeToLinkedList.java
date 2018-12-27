package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import model.TreeNode;

public class FlattenBinaryTreeToLinkedList {

  public void flatten(TreeNode root) {
    if (null == root) {
      return;
    }
    Stack<TreeNode> nodeStack = new Stack<>();
    List<TreeNode> list = new ArrayList<>();

    nodeStack.push(root);
    while (!nodeStack.isEmpty()) {
      TreeNode tmp = nodeStack.pop();
      if (tmp.right != null) {
        nodeStack.push(tmp.right);
      }
      if (tmp.left != null) {
        nodeStack.push(tmp.left);
      }

      list.add(tmp);
    }

    for (int i = 0; i < list.size() - 1; i++) {
      list.get(i).left = null;
      list.get(i).right = list.get(i + 1);
    }

  }
}
