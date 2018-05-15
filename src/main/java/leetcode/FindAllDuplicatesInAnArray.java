package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllDuplicatesInAnArray {

  public List<Integer> findDuplicates(int[] nums) {
    List<Integer> ret = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      int tmp = Math.abs(nums[i]);
      int target = nums[tmp - 1];
      if (target < 0) {
        ret.add(Math.abs(tmp));
      } else {
        nums[tmp - 1] = -target;
      }
    }

    return ret;

  }
}
