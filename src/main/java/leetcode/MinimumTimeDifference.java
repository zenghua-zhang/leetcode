package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.junit.Test;

public class MinimumTimeDifference {

  public int findMinDifference(List<String> timePoints) {
    Comparator<String> comparator = (String o1, String o2) -> {
      int[] time1 = getTime(o1);
      int[] time2 = getTime(o2);
      if (time1[0] != time2[0]) {
        return time1[0] - time2[0];
      }
      return time1[1] - time2[1];
    };

    timePoints.sort(comparator);

    int ret = Integer.MAX_VALUE;
    for (int i = 1; i < timePoints.size(); i++) {
      ret = Math.min(ret, calDiff(timePoints.get(i - 1), timePoints.get(i)));
    }
    ret = Math.min(ret, calDiff(timePoints.get(timePoints.size() - 1), timePoints.get(0)));

    return ret;
  }

  private int[] getTime(String s) {
    int[] time = new int[2];
    String[] strs = s.split(":");
    time[0] = Integer.valueOf(strs[0]);
    time[1] = Integer.valueOf(strs[1]);

    return time;
  }

  private int calDiff(String s1, String s2) {
    int[] time1 = getTime(s1);
    int[] time2 = getTime(s2);

    int hour1 = time1[0];
    int hour2 = time2[0];
    int min1 = time1[1];
    int min2 = time2[1];

    if (hour1 > hour2 || (hour1 == hour2 && min1 > min2)) {
      hour2 += 24;
    }

    return 60 * (hour2 - hour1) + (min2 - min1);
  }

  @Test
  public void test() {
    MinimumTimeDifference md = new MinimumTimeDifference();
    List<String> list = new ArrayList<>();
    list.add("12:12");
    list.add("12:13");
    md.findMinDifference(list);
  }
}
