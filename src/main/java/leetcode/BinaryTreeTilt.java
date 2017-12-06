package leetcode;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import model.TreeNode;
import org.junit.Test;

public class BinaryTreeTilt {

  private int totalTilt = 0;

  public int findTilt(TreeNode root) {
    sum(root);
    return totalTilt;
  }

  private int sum(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left = sum(root.left);
    int right = sum(root.right);
    totalTilt += Math.abs(left - right);
    return root.val + left + right;
  }

  @Test
  public void test() {
    TreeNode root = new TreeNode(1);
    TreeNode left = new TreeNode(2);
    TreeNode right = new TreeNode(3);

    root.left = left;
    root.right = right;
    left.left = new TreeNode(2);

    BinaryTreeTilt btt = new BinaryTreeTilt();
    assertThat(btt.findTilt(root), is(3));
  }
}
