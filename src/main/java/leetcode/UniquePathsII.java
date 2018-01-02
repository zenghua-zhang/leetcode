package leetcode;

public class UniquePathsII {

  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
      return 0;
    }
    if (obstacleGrid[0][0] == 1) {
      return 0;
    }
    int row = obstacleGrid.length;
    int column = obstacleGrid[0].length;
    int[][] ret = new int[row][column];

    ret[0][0] = 1;

    for (int i = 1; i < column; i++) {
      if (obstacleGrid[0][i] == 1 || ret[0][i - 1] == 0) {
        ret[0][i] = 0;
      } else {
        ret[0][i] = 1;
      }
    }
    for (int i = 1; i < row; i++) {
      if (obstacleGrid[i][0] == 1 || ret[i - 1][0] == 0) {
        ret[i][0] = 0;
      } else {
        ret[i][0] = 1;
      }
    }
    for (int i = 1; i < row; i++) {
      for (int j = 1; j < column; j++) {
        if (obstacleGrid[i][j] == 1) {
          ret[i][j] = 0;
        } else {
          ret[i][j] = ret[i - 1][j] + ret[i][j - 1];
        }
      }
    }

    return ret[row - 1][column - 1];
  }

}
