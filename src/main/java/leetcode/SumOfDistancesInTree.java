package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SumOfDistancesInTree {

  public int[] sumOfDistancesInTree(int N, int[][] edges) {
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
