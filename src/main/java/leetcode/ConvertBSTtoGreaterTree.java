package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import model.TreeNode;

public class ConvertBSTtoGreaterTree {

  public TreeNode convertBST(TreeNode root) {
    List<Integer> list = new ArrayList<>();

    addToList(list, root);

    if (list.size() == 0) {
      return root;
    }

    Stack<Integer> stack = new Stack<>();
    stack.push(list.get(list.size() - 1));
    for (int n = list.size() - 2; n >= 0; n--) {
      int v = list.get(n);
      stack.push(v + stack.peek());
    }

    popFromStack(stack, root);

    return root;
  }

  private void addToList(List<Integer> list, TreeNode root) {
    if (root == null) {
      return;
    }
    addToList(list, root.left);
    list.add(root.val);
    addToList(list, root.right);
  }

  private void popFromStack(Stack<Integer> stack, TreeNode root) {
    if (root == null) {
      return;
    }
    popFromStack(stack, root.left);
    root.val = stack.pop();
    popFromStack(stack, root.right);
  }
}
