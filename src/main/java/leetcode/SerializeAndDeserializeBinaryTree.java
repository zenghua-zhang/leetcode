package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import model.TreeNode;

public class SerializeAndDeserializeBinaryTree {

  public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
      List<String> list = new ArrayList<>();
      serialize(root, list);
      return String.join(",", list);
    }

    private void serialize(TreeNode root, List<String> list) {
      if (root == null) {
        list.add("#");
        return;
      }
      list.add(root.val + "");
      serialize(root.left, list);
      serialize(root.right, list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
      LinkedList list = new LinkedList(Arrays.asList(data.split(",")));

      return deserialize(list);
    }

    private TreeNode deserialize(LinkedList<String> list) {
      String v = list.pop();
      if (v.equals("#")) {
        return null;
      }

      TreeNode root = new TreeNode(Integer.valueOf(v));
      root.left = deserialize(list);
      root.right = deserialize(list);

      return root;


    }
  }
}
