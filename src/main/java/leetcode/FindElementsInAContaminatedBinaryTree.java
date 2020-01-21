package leetcode;

import java.util.BitSet;
import model.TreeNode;

public class FindElementsInAContaminatedBinaryTree {

  class FindElements {

    private BitSet bitSet = new BitSet();

    public FindElements(TreeNode root) {
      dfs(root, 0);

    }

    private void dfs(TreeNode root, int pos) {
      if (root == null) {
        return;
      }
      bitSet.set(pos);

      dfs(root.left, pos * 2 + 1);
      dfs(root.right, pos * 2 + 2);
    }

    public boolean find(int target) {
      return bitSet.get(target);
    }
  }


}
