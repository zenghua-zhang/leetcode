package leetcode;

import java.util.Map;
import java.util.TreeMap;

public class FindRightInterval {

  public int[] findRightInterval(Interval[] intervals) {
    int[] ret = new int[intervals.length];

    TreeMap<Integer, Integer> map = new TreeMap<>();
    for (int i = 0; i < intervals.length; i++) {
      Interval interval = intervals[i];
      map.put(interval.start, i);
    }

    for (int i = 0; i < intervals.length; i++) {
      Interval interval = intervals[i];
      Map.Entry<Integer, Integer> entry = map.ceilingEntry(interval.end);
      Integer higher = entry == null ? -1 : entry.getValue();
      ret[i] = higher;
    }

    return ret;
  }
}
