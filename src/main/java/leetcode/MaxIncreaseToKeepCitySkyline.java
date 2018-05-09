package leetcode;

public class MaxIncreaseToKeepCitySkyline {

  public int maxIncreaseKeepingSkyline(int[][] grid) {
    int[] rowMax = new int[grid[0].length];
    int[] lineMax = new int[grid.length];

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        int val = grid[i][j];
        rowMax[j] = Math.max(rowMax[j], val);
        lineMax[i] = Math.max(lineMax[i], val);
      }
    }

    int ret = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        int val = grid[i][j];
        int min = Math.min(rowMax[j], lineMax[i]);
        ret += min - val;
      }
    }

    return ret;
  }

  public static void main(String[] args) {
    MaxIncreaseToKeepCitySkyline t = new MaxIncreaseToKeepCitySkyline();

    int[][] grid = new int[4][];
    grid[0] = new int[]{3, 0, 8, 4};
    grid[1] = new int[]{2, 4, 5, 7};
    grid[2] = new int[]{9, 2, 6, 3};
    grid[3] = new int[]{0, 3, 1, 0};

    t.maxIncreaseKeepingSkyline(grid);
  }
}
