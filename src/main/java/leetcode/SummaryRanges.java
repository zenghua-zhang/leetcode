package leetcode;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;

public class SummaryRanges {

  public List<String> summaryRanges(int[] nums) {
    if (nums.length < 1) {
      return new ArrayList<>();
    }
    List<int[]> list = new LinkedList<>();
    int[] tmp = new int[]{
        nums[0], nums[0]
    };

    for (int i = 1; i < nums.length; i++) {
      if (nums[i] - 1 == nums[i - 1]) {
        tmp[1] = nums[i];
      } else {
        list.add(tmp);
        tmp = new int[]{
            nums[i], nums[i]
        };
      }
    }
    list.add(tmp);

    return list.stream().map(ints -> ints[0] == ints[1] ? String.valueOf(ints[0]) : ints[0] + "->" + ints[1]).collect(Collectors.toList());
  }

  @Test
  public void test() {
    SummaryRanges sr = new SummaryRanges();
    assertThat(sr.summaryRanges(new int[]{0, 1, 2, 4, 5, 7}), contains("0->2", "4->5", "7"));
    assertThat(sr.summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}), contains("0", "2->4", "6", "8->9"));
    assertThat(sr.summaryRanges(new int[]{0}), contains("0"));

  }
}
