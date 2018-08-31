package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.TreeNode;

public class AllPossibleFullBinaryTrees {

  Map<Integer, List<TreeNode>> map;

  public List<TreeNode> allPossibleFBT(int N) {
    if ((N & 1) != 1) {
      return new ArrayList<>();
    }
    init();

    if (N <= 3) {
      return map.get(N);
    }

    for (int i = 5; i <= N; i = i + 2) {
      exec(i);
    }

    return map.get(N);
  }

  private void init() {
    map = new HashMap<>();

    List<TreeNode> list1 = new ArrayList<>();
    list1.add(new TreeNode(0));
    map.put(1, list1);

    List<TreeNode> list3 = new ArrayList<>();
    TreeNode root = new TreeNode(0);
    root.left = new TreeNode(0);
    root.right = new TreeNode(0);

    list3.add(root);
    map.put(3, list3);
  }

  private void exec(int n) {
    List<TreeNode> list = new ArrayList<>();
    for (int i = 1; i < n; i = i + 2) {
      List<TreeNode> leftList = map.get(i);
      List<TreeNode> rightList = map.get(n - 1 - i);
      for (TreeNode left : leftList) {
        for (TreeNode right : rightList) {
          TreeNode root = new TreeNode(0);
          root.left = copy(left);
          root.right = copy(right);

          list.add(root);
        }
      }
    }
    map.put(n, list);
  }

  private TreeNode copy(TreeNode root) {
    if (null == root) {
      return null;
    }
    TreeNode copy = new TreeNode(root.val);
    copy.left = copy(root.left);
    copy.right = copy(root.right);

    return copy;
  }

}
