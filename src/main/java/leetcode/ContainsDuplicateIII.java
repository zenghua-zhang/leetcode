package leetcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class ContainsDuplicateIII {

  public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    if (nums.length == 0 || k <= 0 || t < 0) {
      return false;
    }

    TreeMap<Long, List<Integer>> valuePosMap = new TreeMap<>();

    for (int i = 0; i < nums.length; i++) {
      valuePosMap.computeIfAbsent((long) nums[i], n -> new ArrayList<>()).add(i);
    }

    for (Long i : valuePosMap.keySet()) {

      TreeSet<Integer> sortedPosition = valuePosMap.subMap(i, true, i + t, true)
          .values()
          .stream()
          .flatMap(Collection::stream)
          .collect(Collectors.toCollection(TreeSet::new));

      if (sortedPosition.stream().anyMatch(position -> !sortedPosition.floor(position + k).equals(position))) {
        return true;
      }
    }

    return false;
  }

}
