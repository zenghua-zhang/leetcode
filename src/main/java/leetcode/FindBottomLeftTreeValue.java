package leetcode;

import java.util.TreeMap;
import model.TreeNode;

public class FindBottomLeftTreeValue {

  public int findBottomLeftValue(TreeNode root) {
    TreeMap<Integer, Integer> map = new TreeMap<>();
    helper(1, root, map);

    return map.get(map.lastKey());
  }

  public void helper(Integer pos, TreeNode root, TreeMap<Integer, Integer> treeMap) {
    if (root == null) {
      return;
    }
    treeMap.put(pos, root.val);

    helper(pos + 1, root.right, treeMap);
    helper(pos + 1, root.left, treeMap);
  }

}
