package leetcode;

import model.TreeNode;

public class ConstructBinarySearchTreeFromPreorderTraversal {

  public TreeNode bstFromPreorder(int[] preorder) {
    return bst(preorder, 0, preorder.length - 1);
  }

  private TreeNode bst(int[] preorder, int s, int e) {
    if (s > e) {
      return null;
    }
    TreeNode root = new TreeNode(preorder[s]);

    int greater = s;
    while (greater <= e && preorder[greater] <= preorder[s]) {
      greater++;
    }

    root.left = bst(preorder, s + 1, greater - 1);
    root.right = bst(preorder, greater, e);

    return root;
  }
}
