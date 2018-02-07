package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    Arrays.sort(candidates);

    List<List<Integer>> ret = helper(candidates, target, 0);

    return ret;
  }

  private List<List<Integer>> helper(int[] candidates, int target, int start) {
    List<List<Integer>> ret = new ArrayList<>();
    for (int i = start; i < candidates.length; i++) {
      int n = candidates[i];
      int tmp = target - n;
      if (tmp < 0) {
        continue;
      }
      if (tmp == 0) {
        List<Integer> l = new ArrayList<>();
        l.add(n);
        ret.add(l);
      } else {
        List<List<Integer>> l = helper(candidates, tmp, i);
        if (null != l && !l.isEmpty()) {
          for (List<Integer> t : l) {
            List<Integer> r = new ArrayList<>();
            r.add(n);
            r.addAll(t);
            ret.add(r);
          }
        }
      }
    }

    return ret;
  }
}
