package leetcode;

public class ArithmeticSlices {
  public int numberOfArithmeticSlices(int[] A) {
    int ret = 0;
    int tmp = 0;
    for (int i = 2; i < A.length; i++) {
      if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
        tmp++;
      }else{
        while (tmp != 0) {
          ret += tmp;
          tmp--;
        }
      }
    }
    while (tmp != 0) {
      ret += tmp;
      tmp--;
    }
    return ret;
  }
}
