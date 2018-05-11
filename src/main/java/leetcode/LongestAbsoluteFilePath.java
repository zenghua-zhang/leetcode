package leetcode;

import java.util.LinkedList;

public class LongestAbsoluteFilePath {

  public int lengthLongestPath(String input) {
    String[] files = input.split("\\n");
    Node root = new Node(-1, "");
    for (String file : files) {
      int level = 0;
      while (file.startsWith("\t")) {
        file = file.substring(1);
        level++;
      }
      Node node = new Node(level, file);
      root.addChild(node);
    }

    return Math.max(0, root.maxLength());
  }

  private class Node {

    private int level;

    private boolean isFile;

    private int length;

    private LinkedList<Node> subNodes;

    private Node(int level, String str) {
      this.level = level;
      subNodes = new LinkedList<>();
      isFile = str.contains(".");
      length = str.length();
    }

    private void addChild(Node node) {
      if (node.level == level + 1) {
        subNodes.add(node);
      } else {
        subNodes.getLast().addChild(node);
      }
    }

    private int maxLength() {
      if (level > 0) {
        length++;
      }
      if (subNodes.size() == 0) {
        if (isFile) {
          return length;
        } else {
          return -1;
        }
      }
      int childMax = -1;
      for (Node node : subNodes) {
        int child = node.maxLength();
        childMax = Math.max(child, childMax);
      }

      if (childMax == -1) {
        return -1;
      }
      length += childMax;

      return length;
    }
  }
}
