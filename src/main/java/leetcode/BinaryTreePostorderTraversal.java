package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import model.TreeNode;

public class BinaryTreePostorderTraversal {

  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> ret = new ArrayList<>();

    LinkedList<TreeNode> stack = new LinkedList<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode node = stack.pop();
      if (node == null) {
        continue;
      }

      ret.add(node.val);

      stack.push(node.left);
      stack.push(node.right);
    }

    Collections.reverse(ret);

    return ret;
  }
}
