package leetcode;

import java.util.HashSet;
import java.util.Set;

public class IntersectionofTwoArrays {
  public int[] intersection(int[] nums1, int[] nums2) {
    Set<Integer> set1 = toSet(nums1);
    Set<Integer> set2 = toSet(nums2);

    Set<Integer> result = new HashSet<>(set1);
    result.retainAll(set2);

    int[] res = new int[result.size()];
    int i = 0;
    for (Integer n : result) {
      res[i++] = n;
    }

    return res;

  }

  private Set<Integer> toSet(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      set.add(nums[i]);
    }
    return set;
  }
}
