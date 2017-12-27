package leetcode;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import org.junit.Test;

public class TwoKeysKeyboard {

  public int minSteps(int n) {
    if (n == 1) {
      return 0;
    }
    int[] ret = new int[n + 1];
    Arrays.fill(ret, Integer.MAX_VALUE);
    ret[1] = 0;
    ret[2] = 2;
    for (int i = 2; i <= n; i++) {
      ret[i] = Math.min(ret[i], i);
      for (int j = 2, product = i * j; product <= n; j++, product = i * j) {
        ret[product] = Math.min(ret[product], ret[i] + j);
      }
    }

    return ret[n];
  }

  @Test
  public void test() {
    TwoKeysKeyboard tkk = new TwoKeysKeyboard();
    assertThat(tkk.minSteps(18), is(8));

  }
}
