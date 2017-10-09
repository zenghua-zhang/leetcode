package leetcode;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import model.TreeNode;
import org.junit.Test;

public class PrintBinaryTree {

  public List<List<String>> printTree(TreeNode root) {
    List<List<String>> result = new ArrayList<>();
    int length = getLength(root);
    int listSize = (1 << length) - 1;
    for (int i = 0; i < length; i++) {
      List<String> list = new ArrayList<>(Collections.nCopies(listSize, ""));
      result.add(list);
    }

    setInt(root, result, 0, 0, listSize - 1);

    return result;
  }

  private void setInt(TreeNode root, List<List<String>> result, int pos, int start, int end) {
    int mid = (start + end) / 2;
    if (null != root) {
      result.get(pos).set(mid, root.val + "");

      setInt(root.left, result, pos + 1, start, mid - 1);
      setInt(root.right, result, pos + 1, mid + 1, end);
    }
  }

  private int getLength(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int l = getLength(root.left);
    int r = getLength(root.right);
    return Math.max(l, r) + 1;
  }

  @Test
  public void test() {
    PrintBinaryTree pbt = new PrintBinaryTree();

    TreeNode node1 = new TreeNode(1);
    int length = pbt.getLength(node1);
    int listSize = (1 << length) - 1;
    assertThat(listSize, is(1));

    TreeNode node2 = new TreeNode(2);
    node1.left = node2;
    length = pbt.getLength(node1);
    listSize = (1 << length) - 1;
    assertThat(listSize, is(3));

    TreeNode node3 = new TreeNode(3);
    node2.right = node3;
    length = pbt.getLength(node1);
    listSize = (1 << length) - 1;
    assertThat(listSize, is(7));

    List<List<String>> result = pbt.printTree(node1);
    for (List<String> l : result) {
      System.out.println(l.stream().collect(Collectors.joining(",")));
    }

  }
}
