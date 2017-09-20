package leetcode;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class TrappingRainWater {

  public int trap(int[] height) {
    int length = height.length;
    if (length < 2) {
      return 0;
    }

    int[] front = new int[length], end = new int[length], max = new int[length];
    front[0] = height[0];
    end[length - 1] = height[length - 1];

    for (int i = 1; i < length; i++) {
      front[i] = Math.max(height[i], front[i - 1]);
    }
    for (int i = length - 2; i >= 0; i--) {
      end[i] = Math.max(height[i], end[i + 1]);
    }

    for (int i = 0; i < length; i++) {
      max[i] = Math.min(front[i], end[i]);
    }

    int ret = 0;
    for (int i = 0; i < length; i++) {
      ret += max[i] - height[i];
    }

    return ret;
  }

  @Test
  public void test() {
    TrappingRainWater water = new TrappingRainWater();
    assertThat(water.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}), is(6));
    assertThat(water.trap(new int[]{1, 0, 2}), is(1));
    assertThat(water.trap(new int[]{1}), is(0));
    assertThat(water.trap(new int[]{0}), is(0));
    assertThat(water.trap(new int[]{1, 2, 3, 4, 5}), is(0));
    assertThat(water.trap(new int[]{9, 8, 7, 6, 5, 4, 3, 2}), is(0));
  }
}
