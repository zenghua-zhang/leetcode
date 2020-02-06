package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

  private int[] candidates;

  private int target;

  private List<List<Integer>> result;

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    result = new ArrayList<>();
    this.target = target;

    Arrays.sort(candidates);
    this.candidates = candidates;

    List<Integer> list = new ArrayList<>();
    helper(list, 0, 0);

    return result;
  }

  private void helper(List<Integer> list, int sum, int pos) {
    if (sum == target) {
      result.add(new ArrayList<>(list));
      return;
    }

    for (int i = pos; i < candidates.length; i++) {
      int num = candidates[i];
      if (sum + num > target) {
        continue;
      }

      list.add(num);
      helper(list, sum + num, i);
      list.remove(list.size() - 1);
    }

  }


  public List<List<Integer>> combinationSumOld(int[] candidates, int target) {
    Arrays.sort(candidates);

    List<List<Integer>> ret = helperOld(candidates, target, 0);

    return ret;
  }

  private List<List<Integer>> helperOld(int[] candidates, int target, int start) {
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
        List<List<Integer>> l = helperOld(candidates, tmp, i);
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
