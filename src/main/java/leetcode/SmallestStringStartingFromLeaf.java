package leetcode;

import java.util.LinkedList;
import model.TreeNode;

public class SmallestStringStartingFromLeaf {

  public String smallestFromLeaf(TreeNode root) {
    LinkedList<InnerClass> queue = new LinkedList<>();

    String result = null;
    queue.add(new InnerClass(root));

    while (!queue.isEmpty()) {

      InnerClass inner = queue.pop();

      TreeNode node = inner.node;
      if (node.left != null) {
        queue.push(inner.copy(node.left));
      }
      if (node.right != null) {
        queue.push(inner.copy(node.right));
      }
      if (node.left == null && node.right == null) {
        result = compare(result, inner.characters);
      }

    }

    return result;
  }

  private String compare(String str, StringBuilder characters) {

    String compare = characters.reverse().toString();

    if (str == null) {
      return compare;
    }

    return str.compareTo(compare) < 0 ? str : compare;
  }

  private static class InnerClass {

    private TreeNode node;

    private StringBuilder characters = new StringBuilder();


    private InnerClass(TreeNode node) {
      this.node = node;
      this.characters.append((char) (node.val + 'a'));
    }

    private InnerClass() {
    }

    private InnerClass copy(TreeNode node) {
      InnerClass copy = new InnerClass();

      copy.node = node;
      copy.characters = new StringBuilder(this.characters);
      copy.characters.append((char) (node.val + 'a'));

      return copy;
    }
  }

}
