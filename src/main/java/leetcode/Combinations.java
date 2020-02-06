package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

  private int size;

  private int max;

  private List<List<Integer>> result;

  public List<List<Integer>> combine(int n, int k) {
    result = new ArrayList<>();
    size = k;
    max = n;

    helper(new ArrayList<>(), 1);

    return result;

  }

  private void helper(List<Integer> list, int pos) {
    if (list.size() == size) {
      result.add(new ArrayList<>(list));
    }

    for (int i = pos; i <= max; i++) {

      list.add(i);
      helper(list, i + 1);
      list.remove(list.size() - 1);
    }
  }
}
