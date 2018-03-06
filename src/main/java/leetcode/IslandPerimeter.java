package leetcode;

public class IslandPerimeter {

  public int islandPerimeter(int[][] grid) {
    int total = 0;
    if (null == grid || grid.length == 0 || grid[0].length == 0) {
      return total;
    }
    int rows = grid.length;
    int length = grid[0].length;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == 0) {
          continue;
        }
        int perimeter = 0;
        if (i == 0 || grid[i - 1][j] == 0) {
          perimeter++;
        }
        if (j == 0 || grid[i][j - 1] == 0) {
          perimeter++;
        }
        if (i == rows - 1 || grid[i + 1][j] == 0) {
          perimeter++;
        }
        if (j == length - 1 || grid[i][j + 1] == 0) {
          perimeter++;
        }

        total += perimeter;
      }
    }

    return total;
  }
}
