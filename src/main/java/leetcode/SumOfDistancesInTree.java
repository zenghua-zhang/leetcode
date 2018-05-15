package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class SumOfDistancesInTree {

  public int[] sumOfDistancesInTree(int N, int[][] edges) {
    //timeout again
    int[] ret = new int[N];
    Node[] nodes = new Node[N];
    for (int i = 0; i < N; i++) {
      nodes[i] = new Node(i, N);
    }
    for (int[] ints : edges) {
      Node parent = nodes[ints[0]];
      Node child = nodes[ints[1]];

      if (child.parent != null && parent.parent != null) {
        child.reverseParent(null);
        parent.addChild(child);
      } else if (child.parent == null) {
        parent.addChild(child);
      } else {
        child.addChild(parent);
      }
    }

    Node root = nodes[0].findRoot();

    root.postOrder();

    root.preOrder(ret);

    return ret;
  }

  private class Node {

    private int n;

    private Set<Node> children;

    private Node parent;

    private int[] distances;

    public Node(int n, int N) {
      this.n = n;
      distances = new int[N];
    }

    public void addChild(Node child) {
      if (children == null) {
        children = new HashSet<>();
      }
      children.add(child);
      child.parent = this;
    }

    public Node findRoot() {
      if (parent == null) {

        return this;
      }
      return parent.findRoot();
    }

    public void preOrder(int[] ret) {
      if (parent != null) {
        for (int i = 0; i < distances.length; i++) {
          if (distances[i] == 0 && i != n) {
            distances[i] = parent.distances[i] + 1;
          }
        }
      }

      for (int i : distances) {
        ret[n] += i;
      }
      if (children != null) {
        for (Node child : children) {
          child.preOrder(ret);
        }
      }
    }

    public void reverseParent(Node parent) {
      if (this.parent == null) {
        return;
      }

      Node tmp = this.parent;
      this.parent = null;
      tmp.reverseParent(this);
      tmp.children.remove(this);
      addChild(tmp);
    }

    public void postOrder() {
      if (null == children || 0 == children.size()) {
        return;
      }

      for (Node child : children) {
        distances[child.n] = 1;
        child.postOrder();
      }

      for (Node child : children) {
        int childDis = distances[child.n];
        for (int i = 0; i < distances.length; i++) {
          if (child.distances[i] != 0) {
            distances[i] += childDis + child.distances[i];
          }
        }
      }
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Node node = (Node) o;
      return n == node.n;
    }

    @Override
    public int hashCode() {
      return Objects.hash(n);
    }

  }


  public int[] sumOfDistancesInTreeWithMatrix(int N, int[][] edges) {
    //Timeout in leetcode
    int[] ret = new int[N];
    int[][] matrix = new int[N][N];
    for (int[] ints : edges) {
      matrix[ints[0]][ints[1]] = 1;
      matrix[ints[1]][ints[0]] = 1;
    }

    for (int i = 1; i <= N; i++) {
//      printMatrix(matrix);
      for (int from = 0; from < N; from++) {
        for (int to = 0; to < N; to++) {
          if (matrix[from][to] == i) {
            for (int j = 0; j < N; j++) {
              if (matrix[from][j] != 0 || matrix[to][j] != 1 || from == j) {
                continue;
              }
              matrix[from][j] = i + 1;
              matrix[j][from] = i + 1;
            }
          }
        }
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j : matrix[i]) {
        ret[i] += j;
      }
    }

    return ret;
  }

  private void printMatrix(int[][] matrix) {
    for (int[] ints : matrix) {
      System.out.println(Arrays.toString(ints));
    }

    System.out.println("-----------------");
  }

  public int[] sumOfDistancesInTreeWithClass(int N, int[][] edges) {
    //Timeout in leetcode
    int[] ret = new int[N];
    Map<Link, Integer> map = new HashMap<>();
    for (int[] ints : edges) {
      map.put(new Link(ints[0], ints[1]), 1);
      map.put(new Link(ints[1], ints[0]), 1);
    }
//    printMap(map, N);

    for (int i = 1; i <= N; i++) {
      Map<Link, Integer> cloneMap = new HashMap<>(map);
      for (Map.Entry<Link, Integer> entry : cloneMap.entrySet()) {
        if (entry.getValue() == i) {
          int from = entry.getKey().from;
          int to = entry.getKey().to;

          for (int j = 0; j < N; j++) {
            if (j == from) {
              continue;
            }
            Link l = new Link(to, j);
            Integer distance = map.get(l);
            if (distance != null && distance == 1 && !map.containsKey(new Link(from, j))) {
              map.put(new Link(from, j), i + 1);
              map.put(new Link(j, from), i + 1);
            }
          }
        }
      }
      // map = cloneMap;
      //printMap(map, N);
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        ret[i] += map.getOrDefault(new Link(i, j), 0);
      }
    }

    return ret;
  }

  private class Link {

    private int from;
    private int to;

    public Link(int from, int to) {
      this.from = from;
      this.to = to;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Link link = (Link) o;
      return from == link.from &&
          to == link.to;
    }

    @Override
    public int hashCode() {

      return Objects.hash(from, to);
    }
  }

  private void printMap(Map<Link, Integer> map, int N) {

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        System.out.print(map.getOrDefault(new Link(i, j), 0));
      }
      System.out.println("");
    }
    System.out.println("-----------");
  }
}
