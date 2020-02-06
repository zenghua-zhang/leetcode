package leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {

  private int sizeLimit;

  private int target;

  private List<List<Integer>> result;

  public List<List<Integer>> combinationSum3(int k, int n) {
    this.target = n;
    this.sizeLimit = k;
    result = new ArrayList<>();

    helper(new ArrayList<>(), 0, 1);

    return result;
  }

  private void helper(List<Integer> list, int sum, int pos) {
    if (list.size() == sizeLimit && sum == target) {
      result.add(new ArrayList<>(list));
      return;
    }

    for (int i = pos; i <= 9; i++) {
      if (sum + i > target) {
        break;
      }

      list.add(i);
      helper(list, sum + i, i + 1);
      list.remove(list.size() - 1);
    }
  }


}
