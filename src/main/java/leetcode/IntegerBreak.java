package leetcode;

import org.junit.Test;

public class IntegerBreak {

  public int integerBreak(int n) {
    if (n == 2) {
      return 1;
    }
    int[] rets = new int[n + 1];
    rets[0] = 1;
    rets[1] = 1;
    rets[2] = 2;
    for (int i = 3; i <= n; i++) {
      int max = Integer.MIN_VALUE;
      for (int j = i - 1; j >= i / 2; j--) {
        max = Math.max(max, (i - j) * rets[j]);
      }
      if (i != n) {
        max = Math.max(i, max);
      }
      rets[i] = max;
    }

    return rets[n];
  }

  @Test
  public void test() {
    IntegerBreak ib = new IntegerBreak();
    System.out.println(ib.integerBreak(11));
  }
}
