package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import org.junit.Test;

public class RelativeRanks {

  public String[] findRelativeRanks(int[] nums) {
    TreeMap<Integer, Integer> sorted = new TreeMap<>(Comparator.reverseOrder());
    for (int i = 0; i < nums.length; i++) {
      sorted.put(nums[i], i);
    }

    String[] result = new String[nums.length];

    int rank = 1;
    for (Map.Entry<Integer, Integer> entry : sorted.entrySet()) {
      String rankStr = "";
      if (rank == 1) {
        rankStr = "Gold Medal";
      } else if (rank == 2) {
        rankStr = "Silver Medal";
      } else if (rank == 3) {
        rankStr = "Bronze Medal";
      } else {
        rankStr = rank + "";
      }

      result[entry.getValue()] = rankStr;
      rank++;
    }

    return result;
  }

  @Test
  public void test() {
    RelativeRanks rr = new RelativeRanks();
    System.out.println(Arrays.toString(rr.findRelativeRanks(new int[]{1, 2, 3, 4, 5})));
  }
}
