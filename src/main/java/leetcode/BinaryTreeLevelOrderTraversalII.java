package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import model.TreeNode;

public class BinaryTreeLevelOrderTraversalII {

  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    List<List<Integer>> resultList = new ArrayList<List<Integer>>();
    if (root == null) {
      return resultList;
    }
    LinkedList<TreeNode> list = new LinkedList<TreeNode>();
    LinkedList<TreeNode> nextList = new LinkedList<TreeNode>();
    nextList.push(root);
    while (!nextList.isEmpty()) {
      List<Integer> l = new ArrayList<Integer>();
      while (!nextList.isEmpty()) {
        TreeNode node = nextList.pop();
        l.add(node.val);
        if (node.left != null) {
          list.add(node.left);
        }
        if (node.right != null) {
          list.add(node.right);
        }
      }
      resultList.add(l);
      nextList.addAll(list);
      list.clear();
    }

    Collections.reverse(resultList);

    return resultList;
  }
}
