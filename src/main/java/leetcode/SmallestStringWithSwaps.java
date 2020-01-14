package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class SmallestStringWithSwaps {

  public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
    UnionFind uf = new UnionFind(s.length());

    for (List<Integer> pair : pairs) {
      uf.union(pair.get(0), pair.get(1));
    }

    Map<Integer, PriorityQueue<Character>> map = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
      int root = uf.findRoot(i);
      map.computeIfAbsent(root, character -> new PriorityQueue<>()).add(s.charAt(i));
    }

    char[] result = new char[s.length()];

    for (int i = 0; i < s.length(); i++) {
      int root = uf.findRoot(i);
      result[i] = map.get(root).poll();
    }

    return new String(result);
  }

  private static class UnionFind {

    private final int[] id;

    private final int[] size;

    private UnionFind(int n) {
      this.id = new int[n];
      this.size = new int[n];

      for (int i = 0; i < n; i++) {
        id[i] = i;
        size[i] = 1;
      }
    }

    private int findRoot(int p) {
      while (p != id[p]) {
        id[p] = id[id[p]];
        p = id[p];
      }

      return p;
    }

    private void union(int s, int d) {
      int sRoot = findRoot(s);
      int dRoot = findRoot(d);

      if (sRoot == dRoot) {
        return;
      }

      if (size[sRoot] > size[dRoot]) {
        id[dRoot] = sRoot;
        size[sRoot] += size[dRoot];
      } else {
        id[sRoot] = dRoot;
        size[dRoot] += size[sRoot];
      }

    }


  }


}
