package leetcode;

import java.util.LinkedList;
import model.TreeNode;

public class SmallestSubtreeWithAllTheDeepestNodes {

  private LinkedList<TreeNode> deepestNodes;

  private int deepest;

  public TreeNode subtreeWithAllDeepest(TreeNode root) {
    deepestNodes = new LinkedList<>();
    deepest = 0;

    findDeepest(root, 0);

    if (deepestNodes.size() == 1) {
      return deepestNodes.get(0);
    }

    TreeNode lca = lca(root, deepestNodes.poll(), deepestNodes.poll());

    while (!deepestNodes.isEmpty()) {
      lca = lca(root, deepestNodes.poll(), lca);
    }

    return lca;
  }

  private TreeNode lca(TreeNode root, TreeNode l, TreeNode r) {
    if (root == null || root.val == l.val || root.val == r.val) {
      return root;
    }

    TreeNode lfind = lca(root.left, l, r);
    TreeNode rfind = lca(root.right, l, r);

    if (lfind != null && rfind != null) {
      return root;
    }

    return lfind != null ? lfind : rfind;
  }

  private void findDeepest(TreeNode root, int depth) {
    if (root == null) {
      return;
    }
    if (depth > deepest) {
      deepestNodes = new LinkedList<>();
      deepestNodes.add(root);
      deepest = depth;
    } else if (depth == deepest) {
      deepestNodes.add(root);
    }

    findDeepest(root.left, depth + 1);
    findDeepest(root.right, depth + 1);
  }

}
