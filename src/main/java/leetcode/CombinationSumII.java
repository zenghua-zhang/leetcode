package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

  private List<List<Integer>> result;

  private int[] candidates;

  private boolean[] visited;

  private int target;

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    result = new ArrayList<>();
    visited = new boolean[candidates.length];

    Arrays.sort(candidates);
    this.candidates = candidates;
    this.target = target;

    helper(new ArrayList<>(), 0, 0);

    return result;
  }

  private void helper(List<Integer> list, int sum, int pos) {
    if (sum == target) {
      result.add(new ArrayList<>(list));
      return;
    }

    for (int i = pos; i < candidates.length; i++) {
      int num = candidates[i];

      if (i != 0 && candidates[i] == candidates[i - 1] && !visited[i - 1]) {
        continue;
      }

      if (sum + num > target) {
        break;
      }

      list.add(num);
      visited[i] = true;
      helper(list, sum + num, i + 1);
      list.remove(list.size() - 1);
      visited[i] = false;
    }

  }


}
