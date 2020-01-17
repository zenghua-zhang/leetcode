package leetcode;

import java.util.HashSet;
import java.util.Set;

public class NumberOfOperationsToMakeNetworkConnected {

  public int makeConnected(int n, int[][] connections) {
    UnionFind uf = new UnionFind(n);

    int canRemove = 0;

    for (int[] connection : connections) {
      int s = connection[0];
      int d = connection[1];

      if (uf.isConnected(s, d)) {
        canRemove++;
      } else {
        uf.union(s, d);
      }
    }

    Set<Integer> roots = new HashSet<>();
    for (int i = 0; i < n; i++) {
      roots.add(uf.findRoot(i));
    }

    if (roots.size() == 1) {
      return 0;
    }

    return roots.size() - 1 <= canRemove ? roots.size() - 1 : -1;
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

    private boolean isConnected(int s, int d) {
      return findRoot(s) == findRoot(d);
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
