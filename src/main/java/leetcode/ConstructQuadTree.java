package leetcode;

import java.util.Arrays;

public class ConstructQuadTree {

  public Node construct(int[][] grid) {
    if (grid.length == 1) {
      Node node = new Node();
      node.isLeaf = true;
      node.val = grid[0][0] == 1;
      return node;
    }

    int mid = grid.length / 2;

    int[][] topLeft = new int[mid][];
    int[][] topRight = new int[mid][];
    int[][] bottomLeft = new int[mid][];
    int[][] bottomRight = new int[mid][];

    for (int i = 0; i < grid.length; i++) {
      int[] row = grid[i];
      if (i < mid) {
        topLeft[i] = Arrays.copyOfRange(row, 0, mid);
        topRight[i] = Arrays.copyOfRange(row, mid, grid.length);
      } else {
        bottomLeft[i - mid] = Arrays.copyOfRange(row, 0, mid);
        bottomRight[i - mid] = Arrays.copyOfRange(row, mid, grid.length);
      }
    }

    Node tlNode = construct(topLeft);
    Node trNode = construct(topRight);
    Node blNode = construct(bottomLeft);
    Node brNode = construct(bottomRight);

    Node root = new Node();

    boolean leafSame = tlNode.isLeaf && trNode.isLeaf && blNode.isLeaf && brNode.isLeaf;
    boolean valSame = allSame(tlNode.val, trNode.val, blNode.val, brNode.val);

    if (leafSame && valSame) {
      root.isLeaf = true;
      root.val = tlNode.val;
    } else {
      root.isLeaf = false;
      root.topLeft = tlNode;
      root.topRight = trNode;
      root.bottomLeft = blNode;
      root.bottomRight = brNode;
    }
    if (mid == 4) {
      System.out.println(tlNode);
      System.out.println(trNode);
      System.out.println(blNode);
      System.out.println(brNode);

    }

    return root;
  }

  private boolean allSame(boolean... booleans) {
    boolean b = booleans[0];
    for (int i = 1; i < booleans.length; i++) {
      if (b != booleans[i]) {
        return false;
      }
    }
    return true;
  }


  class Node {

    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {
    }

    @Override
    public String toString() {
      final StringBuffer sb = new StringBuffer("Node{");
      sb.append("val=").append(val);
      sb.append(", isLeaf=").append(isLeaf);
      sb.append(", topLeft=").append(topLeft);
      sb.append(", topRight=").append(topRight);
      sb.append(", bottomLeft=").append(bottomLeft);
      sb.append(", bottomRight=").append(bottomRight);
      sb.append('}');
      return sb.toString();
    }

    public Node(boolean _val, boolean _isLeaf, Node _topLeft, Node _topRight, Node _bottomLeft, Node _bottomRight) {
      val = _val;
      isLeaf = _isLeaf;
      topLeft = _topLeft;
      topRight = _topRight;
      bottomLeft = _bottomLeft;
      bottomRight = _bottomRight;
    }
  }

  ;

}
