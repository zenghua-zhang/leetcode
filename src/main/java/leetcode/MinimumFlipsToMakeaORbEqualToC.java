package leetcode;

import java.util.Arrays;

public class MinimumFlipsToMakeaORbEqualToC {

  public int minFlips(int a, int b, int c) {

    boolean[] aInts = new boolean[32];
    boolean[] bInts = new boolean[32];
    boolean[] cInts = new boolean[32];

    for (int i = 0; i < 32; i++) {
      aInts[i] = ((a >>> i) & 1) == 1;
      bInts[i] = ((b >>> i) & 1) == 1;
      cInts[i] = ((c >>> i) & 1) == 1;
    }

    int count = 0;
    for (int i = 0; i < 32; i++) {
      boolean ab = aInts[i];
      boolean bb = bInts[i];
      boolean cb = cInts[i];

      if (!cb && (ab || bb)) {
        count += (ab ? 1 : 0) + (bb ? 1 : 0);
      } else if (cb && !ab && !bb) {
        count++;
      }
    }

    return count;

  }

  public static void main(String[] args) {

    MinimumFlipsToMakeaORbEqualToC t = new MinimumFlipsToMakeaORbEqualToC();
    System.out.println(t.minFlips(2, 6, 5));
  }
}
