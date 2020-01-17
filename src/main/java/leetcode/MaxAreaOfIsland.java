package leetcode;

public class MaxAreaOfIsland {

  private int[] size;
  private int[] id;

  private int rowLength;

  public int maxAreaOfIsland(int[][] grid) {
    int l = grid.length * grid[0].length;

    id = new int[l];
    size = new int[l];
    rowLength = grid[0].length;

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < rowLength; j++) {
        if (grid[i][j] == 0) {
          continue;
        }

        int pos = getId(i, j);
        id[pos] = pos;
        size[pos] = 1;

        // up
        int up = i - 1;
        if (up >= 0 && grid[up][j] == 1) {
          union(getId(i, j), getId(up, j));
        }

        // left
        int left = j - 1;
        if (left >= 0 && grid[i][left] == 1) {
          union(getId(i, j), getId(i, left));
        }
      }
    }

    int max = 0;
    for (int i : size) {
      max = Math.max(max, i);
    }

    return max;
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

  private int getId(int i, int j) {
    return i * rowLength + j;
  }


}
