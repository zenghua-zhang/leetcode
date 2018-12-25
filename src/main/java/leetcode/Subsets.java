package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Subsets {

  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> list = helper(nums, 0);
    list.add(Collections.emptyList());
    return list;
  }

  private List<List<Integer>> helper(int[] nums, int start) {
    if (start >= nums.length) {
      return Collections.emptyList();
    }

    List<List<Integer>> list = new ArrayList<>();

    int t = nums[start];

    List<Integer> tmp = new ArrayList<>();
    tmp.add(t);
    list.add(tmp);

    List<List<Integer>> ne = helper(nums, start + 1);
    list.addAll(ne);

    for (List<Integer> integers : ne) {
      List<Integer> l = new ArrayList<>();
      l.add(t);
      l.addAll(integers);
      list.add(l);
    }

    return list;
  }

}
