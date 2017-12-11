package leetcode;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import org.junit.Test;

public class DegreeofAnArray {

  public int findShortestSubArray(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (Integer n : nums) {
      map.computeIfPresent(n, (k, v) -> v + 1);
      map.putIfAbsent(n, 1);
    }

    Entry<Integer, Integer> entry = map.entrySet().stream().max(Entry.comparingByValue()).get();
    int maxFreq = entry.getValue();

    List<Integer> list = map.entrySet().stream().filter(e -> e.getValue() == maxFreq).map(e -> e.getKey()).collect(Collectors.toList());

    int len = Integer.MAX_VALUE;

    for (int i : list) {
      len = Math.min(len, findLength(i, nums));
    }

    return len;
  }

  private int findLength(int val, int[] nums) {
    int start = 0;
    int end = nums.length - 1;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == val) {
        start = i;
        break;
      }
    }

    for (int i = nums.length - 1; i >= 0; i--) {
      if (nums[i] == val) {
        end = i;
        break;
      }
    }

    return end - start + 1;
  }

  @Test
  public void test() {
    DegreeofAnArray daa = new DegreeofAnArray();

    assertThat(daa.findShortestSubArray(new int[]{1, 2, 3, 1, 1, 2}), is(5));
    assertThat(daa.findShortestSubArray(new int[]{1, 2, 3, 4, 5, 6}), is(1));
    assertThat(daa.findShortestSubArray(new int[]{1, 2, 2, 3, 1}), is(2));
    assertThat(daa.findShortestSubArray(new int[]{1, 2, 2, 3, 1, 4, 2}), is(6));

  }
}
