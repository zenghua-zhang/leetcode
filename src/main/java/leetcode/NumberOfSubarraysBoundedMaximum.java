package leetcode;

import java.util.LinkedList;
import java.util.List;

public class NumberOfSubarraysBoundedMaximum {

  public int numSubarrayBoundedMax(int[] A, int L, int R) {
    int less = 0;
    int between = 0;
    List<Integer> list = new LinkedList<>();

    int count = 0;

    for (int i : A) {
      if (i < L) {
        between++;
        less++;
        continue;
      }
      list.add(less);
      less = 0;

      if (i > R) {
        count += caculate(between, list);
        between = 0;
        list.clear();
        continue;
      }

      between++;
    }
    list.add(less);
    count += caculate(between, list);

    return count;
  }

  private int caculate(int between, List<Integer> list) {
    if (between == 0) {
      return 0;
    }

    int sum = sum(between);

    for (int i : list) {
      sum -= sum(i);
    }

    return sum;
  }

  private int sum(int n) {
    return (n + 1) * n / 2;
  }
}
