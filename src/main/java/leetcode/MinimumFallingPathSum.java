package leetcode;

public class MinimumFallingPathSum {

  public int minFallingPathSum(int[][] A) {
    if (A.length == 0 || A[0].length == 0 || A.length != A[0].length) {
      return 0;
    }
    int length = A.length;
    int min = Integer.MAX_VALUE;
    for (int i = 1; i < length; i++) {
      for (int j = 0; j < length; j++) {
        int tmp1 = A[i - 1][j];
        int tmp2;
        if (j == 0) {
          tmp2 = A[i - 1][j + 1];
        } else if (j == length - 1) {
          tmp2 = A[i - 1][j - 1];
        } else {
          tmp2 = Math.min(A[i - 1][j - 1], A[i - 1][j + 1]);
        }
        A[i][j] = A[i][j] + Math.min(tmp1, tmp2);
      }
    }

    for (int i : A[length - 1]) {
      min = Math.min(i, min);
    }

    return min;
  }

}
