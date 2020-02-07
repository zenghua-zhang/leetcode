package leetcode;

import model.TreeNode;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

  private int[] inorder;

  private int[] postorder;

  public TreeNode buildTree(int[] inorder, int[] postorder) {
    this.inorder = inorder;
    this.postorder = postorder;

    return helper(postorder.length - 1, 0, postorder.length - 1);
  }

  private TreeNode helper(int rootPos, int start, int end) {
    if (start > end) {
      return null;
    }

    int rootVal = postorder[rootPos];
    TreeNode root = new TreeNode(rootVal);

    int inorderPos = start;

    while (inorderPos <= end) {
      if (inorder[inorderPos] == rootVal) {
        break;
      }
      inorderPos++;
    }

    root.right = helper(rootPos - 1, inorderPos + 1, rootPos - 1);
    root.left = helper(rootPos - (end - inorderPos) - 1, start, inorderPos - 1);

    return root;
  }

}
