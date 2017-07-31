package leetcode;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import org.junit.Test;

public class CanPlaceFlowers {

  public boolean canPlaceFlowers(int[] flowerbed, int n) {
    for (int i = 0; i < flowerbed.length; i++) {
      if (flowerbed[i] == 1) {
        mark(flowerbed, i);
      }
    }

    for (int i = 0; i < flowerbed.length; i++) {
      if (flowerbed[i] == 0) {
        mark(flowerbed, i);
        n--;
        if (n <= 0) {
          return true;
        }
      }
    }

    return n <= 0;
  }

  private void mark(int[] flowerbed, int i) {
    if (i != 0) {
      flowerbed[i - 1] = -1;
    }
    if (i != flowerbed.length - 1) {
      flowerbed[i + 1] = -1;
    }
  }

  @Test
  public void testFlowers() {
    CanPlaceFlowers f = new CanPlaceFlowers();
    assertThat(f.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1), is(true));
    assertThat(f.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2), is(false));
    assertThat(f.canPlaceFlowers(new int[]{1, 0, 0, 0, 0, 1}, 2), is(false));
    assertThat(f.canPlaceFlowers(new int[]{1, 0, 0, 0, 0, 0, 1}, 2), is(true));
  }
}
