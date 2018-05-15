package leetcode;

import java.util.ArrayList;
import java.util.List;
import model.TreeNode;

public class BinarySearchTreeIterator {

  public class BSTIterator {

    int pos;
    List<Integer> list;

    public BSTIterator(TreeNode root) {
      list = new ArrayList<>();
      pos = 0;
      dfs(root);
    }

    void dfs(TreeNode root) {
      if (root == null) {
        return;
      }
      dfs(root.left);
      list.add(root.val);
      dfs(root.right);
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
      return list.size() != 0 && pos < list.size();
    }

    /**
     * @return the next smallest number
     */
    public int next() {
      int ret = list.get(pos);
      pos++;
      return ret;
    }
  }
}
