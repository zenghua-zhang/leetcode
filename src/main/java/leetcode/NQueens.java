package leetcode;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

  private int max;

  private List<List<String>> result;

  public List<List<String>> solveNQueens(int n) {
    this.max = n;
    result = new ArrayList<>();

    helper(new ArrayList<>(), 0);

    return result;
  }

  private void helper(List<String> list, int row) {

    if (row >= max) {
      result.add(new ArrayList<>(list));
      return;
    }

    for (int i = 0; i < max; i++) {
      if (!canPlace(list, row, i)) {
        continue;
      }

      String line = generateLine(i);
      list.add(line);
      helper(list, row + 1);
      list.remove(list.size() - 1);
    }
  }

  private boolean canPlace(List<String> list, int row, int pos) {
    if (list.isEmpty()) {
      return true;
    }

    for (String s : list) {
      if (s.charAt(pos) == 'Q') {
        return false;
      }
    }

    int left = pos;
    int right = pos;

    while (--row >= 0) {
      String tmp = list.get(row);
      if (--left >= 0 && tmp.charAt(left) == 'Q') {
        return false;
      }
      if (++right < max && tmp.charAt(right) == 'Q') {
        return false;
      }

    }

    return true;
  }

  private String generateLine(int n) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < max; i++) {
      if (i == n) {
        sb.append('Q');
      } else {
        sb.append('.');
      }
    }

    return sb.toString();
  }

  public static void main(String[] args) {
    NQueens queens = new NQueens();

    queens.max = 4;

    for (int i = 0; i < 4; i++) {

      String line = queens.generateLine(i);
      System.out.println(line);
    }

  }


}
