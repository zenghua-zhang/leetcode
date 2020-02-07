package leetcode;

import java.util.ArrayList;
import java.util.List;

public class NQueensII {

  private int max;

  private int count;

  public int totalNQueens(int n) {
    count = 0;
    max = n;

    helper(new ArrayList<>(), 0);

    return count;
  }

  private void helper(List<String> list, int row) {

    if (row >= max) {
      count++;
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

}
