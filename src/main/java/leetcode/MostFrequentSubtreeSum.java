package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.TreeNode;

public class MostFrequentSubtreeSum {

  public int[] findFrequentTreeSum(TreeNode root) {
    Map<Integer, Integer> map = new HashMap<>();
    sumTree(root, map);

    int max = Integer.MIN_VALUE;
    for (int v : map.values()) {
      max = Math.max(max, v);
    }

    List<Integer> ret = new ArrayList<>();
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (entry.getValue() == max) {
        ret.add(entry.getKey());
      }
    }

    int[] ints = new int[ret.size()];
    for (int i = 0; i < ret.size(); i++) {
      ints[i] = ret.get(i);
    }

    return ints;
  }

  private int sumTree(TreeNode node, Map<Integer, Integer> map) {
    if (null == node) {
      return 0;
    }
    int left = sumTree(node.left, map);
    int right = sumTree(node.right, map);

    int sum = node.val + left + right;
    int frequent = map.getOrDefault(sum, 0);
    map.put(sum, frequent + 1);

    return sum;
  }
}
