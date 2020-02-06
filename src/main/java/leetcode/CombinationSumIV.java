package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumIV {

  public int combinationSum4(int[] nums, int target) {

    Arrays.sort(nums);

    int[] dp = new int[target + 1];

    dp[0] = 1;

    for (int i = 1; i <= target; i++) {
      for (int num : nums) {
        if (num > i) {
          break;
        }

        if (dp[i - num] != 0) {
          dp[i] += dp[i - num];
        }
      }
    }

    return dp[target];
  }

  private int target;

  private int[] candidates;

  private int count;

  public int combinationSum4BackTracking(int[] nums, int target) {
    this.target = target;
    Arrays.sort(nums);
    this.candidates = nums;

    this.count = 0;

    helper(new ArrayList<>(), 0);

    return count;
  }

  private void helper(List<Integer> list, int sum) {
    if (sum == target) {
      count++;
      return;
    }

    for (int i = 0; i < candidates.length; i++) {
      int num = candidates[i];
      if (num + sum > target) {
        break;
      }

      list.add(num);
      helper(list, sum + num);

      list.remove(list.size() - 1);
    }

  }


}
