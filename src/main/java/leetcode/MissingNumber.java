package leetcode;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class MissingNumber {

  public int missingNumber(int[] nums) {
    int ret = 0;

    for (int i = 0; i < nums.length; i++) {
      ret = ret ^ nums[i] ^ (i + 1);
    }

    return ret;
  }

  @Test
  public void test() {
    MissingNumber number = new MissingNumber();
    assertThat(number.missingNumber(new int[]{0, 1, 3}), is(2));
    assertThat(number.missingNumber(new int[]{3, 4, 1, 0}), is(2));
    assertThat(number.missingNumber(new int[]{0, 1, 2, 3, 4}), is(5));
  }
}
