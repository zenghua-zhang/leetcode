package leetcode;

import java.util.HashMap;
import java.util.Map;

public class ArrayNesting {

  public int arrayNesting(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      map.put(i, nums[i]);
    }

    int max = Integer.MIN_VALUE;
    for (int i = 0; i < nums.length; i++) {
      if (!map.containsKey(i)) {
        continue;
      }

      int count = 0;
      Integer target = i;
      while (map.containsKey(target)) {
        count++;
        target = map.remove(target);
      }
      max = Math.max(count, max);
    }
    return max;
  }

}
