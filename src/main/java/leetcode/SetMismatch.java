package leetcode;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItemInArray;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

public class SetMismatch {

  public int[] findErrorNums(int[] nums) {
    Set<Integer> exists = new HashSet<>();
    Set<Integer> ret = new HashSet<>();
    for (int i = 1; i <= nums.length; i++) {
      ret.add(i);
    }
    int dup = 0, miss = 0;
    for (int i : nums) {
      if (exists.contains(i)) {
        dup = i;
      }
      exists.add(i);
      ret.remove(i);
    }
    for (Integer i : ret) {
      miss = i;
    }
    return new int[]{dup, miss};
  }

  @Test
  public void test() {
    SetMismatch sm = new SetMismatch();
    int[] result = sm.findErrorNums(new int[]{1, 2, 2, 4});
    assertThat(result, equalTo(new int[]{2, 3}));
  }
}
