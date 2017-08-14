package leetcode;

public class ConstructStringfromBinaryTree {

  public String tree2str(TreeNode t) {
    if (null == t) {
      return "";
    }

    StringBuilder sb = new StringBuilder();
    sb.append(t.val);

    if (null == t.left && null == t.right) {
      return sb.toString();
    }

    sb.append("(").append(tree2str(t.left)).append(")");

    if (null == t.right) {
      return sb.toString();
    }

    sb.append("(").append(tree2str(t.right)).append(")");

    return sb.toString();
  }
}
