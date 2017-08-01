package leetcode;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class TeemoAttacking {

  public int findPoisonedDuration(int[] timeSeries, int duration) {
    if (timeSeries.length == 0) {
      return 0;
    }
    int total = 0;
    for (int i = 0; i < timeSeries.length - 1; i++) {
      int dif = timeSeries[i + 1] - timeSeries[i];
      total += dif > duration ? duration : dif;
    }
    total += duration;
    return total;
  }

  @Test
  public void test() {
    TeemoAttacking ta = new TeemoAttacking();
    assertThat(ta.findPoisonedDuration(new int[]{1, 4}, 2), equalTo(4));
    assertThat(ta.findPoisonedDuration(new int[]{1, 2}, 2), equalTo(3));
    assertThat(ta.findPoisonedDuration(new int[]{1, 4}, 5), equalTo(8));

    assertThat(ta.findPoisonedDuration(new int[]{1, 4, 5, 10}, 2), equalTo(7));

  }
}
