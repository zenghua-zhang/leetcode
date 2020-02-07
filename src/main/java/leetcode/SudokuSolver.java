package leetcode;

public class SudokuSolver {

  private char[][] result;

  private int[][] position;

  public void solveSudoku(char[][] board) {
    result = board;
    position = new int[][]{new int[]{0, 1, 2}, new int[]{3, 4, 5}, new int[]{6, 7, 8}};

    helper(0);
  }

  private boolean helper(int index) {
    if (index == 81) {
      return true;
    }

    int row = index / 9;
    int pos = index % 9;

    char c = result[row][pos];

    if (Character.isDigit(c)) {
      return helper(index + 1);
    }

    boolean[] possibles = getPossibleValue(row, pos);

    for (int i = 1; i < 10; i++) {
      if (possibles[i]) {
        continue;
      }

      result[row][pos] = (char) ('0' + i);

      if (helper(index + 1)) {
        return true;
      }

      result[row][pos] = '.';
    }

    return false;

  }

  private boolean[] getPossibleValue(int row, int pos) {
    boolean[] booleans = new boolean[10];

    for (int i = 0; i < 9; i++) {
      if (i != pos && Character.isDigit(result[row][i])) {
        booleans[result[row][i] - '0'] = true;
      }
    }
    for (int i = 0; i < 9; i++) {
      if (i != row && Character.isDigit(result[i][pos])) {
        booleans[result[i][pos] - '0'] = true;
      }
    }
    for (int i : position[row / 3]) {
      for (int j : position[pos / 3]) {
        if (Character.isDigit(result[i][j])) {
          booleans[result[i][j] - '0'] = true;
        }
      }
    }

    return booleans;

  }

}
