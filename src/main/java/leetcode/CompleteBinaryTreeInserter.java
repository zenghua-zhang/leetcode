package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import model.TreeNode;

public class CompleteBinaryTreeInserter {

  class CBTInserter {

    private List<TreeNode> list = new ArrayList<>();

    public CBTInserter(TreeNode root) {
      if (root == null) {
        return;
      }
      LinkedList<TreeNode> queue = new LinkedList<>();
      queue.add(root);
      while (!queue.isEmpty()) {
        TreeNode node = queue.pop();
        list.add(new TreeNode(node.val));
        addParentToTail();

        if (node.left != null) {
          queue.add(node.left);
        }
        if (node.right != null) {
          queue.add(node.right);
        }
      }
    }

    public int insert(int v) {
      int index = list.size();
      TreeNode node = new TreeNode(v);
      list.add(node);

      TreeNode parent = addParentToTail();
      return parent == null ? 0 : parent.val;
    }

    private TreeNode addParentToTail() {
      int index = list.size() - 1;
      if (index == 0) {
        return null;
      }
      TreeNode node = list.get(index);

      TreeNode parent = list.get((index - 1) / 2);
      if ((index & 1) == 1) {
        parent.left = node;
      } else {
        parent.right = node;
      }

      return parent;

    }

    public TreeNode get_root() {
      if (list.isEmpty()) {
        return null;
      }
      return list.get(0);

    }
  }

}
