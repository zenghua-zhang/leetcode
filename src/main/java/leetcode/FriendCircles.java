package leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FriendCircles {

  public int findCircleNum(int[][] M) {
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < M.length; i++) {
      set.add(i);
    }

    int ret = 0;

    for (int i = 0; i < M.length; i++) {
      if (set.contains(i)) {
        ret++;
        helper(M, set, i);
      }
    }

    return ret;
  }

  private void helper(int[][] M, Set<Integer> set, int row) {
    for (int i = 0; i < M.length; i++) {
      int val = M[row][i];
      if (val == 1 && set.contains(i)) {
        set.remove(i);
        helper(M, set, i);
      }
    }
  }

  public static void main(String[] args) {
    FriendCircles fc = new FriendCircles();
    int[][] ints = new int[][]{new int[]{1, 0, 0, 1}, new int[]{0, 1, 1, 0}, new int[]{0, 1, 1, 1}, new int[]{1, 0, 1, 1}};

    System.out.println(fc.findCircleNum(ints));
  }
}
