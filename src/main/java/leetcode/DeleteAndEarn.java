package leetcode;

import java.util.Arrays;

public class DeleteAndEarn {

  public int deleteAndEarn(int[] nums) {
    int[] ret = new int[10001];
    for (int num : nums) {
      ret[num] += num;
    }
    for (int i = 2; i <= 10000; i++) {
      ret[i] = Math.max(ret[i - 1], ret[i - 2] + ret[i]);
    }
    return ret[10000];
  }
}
