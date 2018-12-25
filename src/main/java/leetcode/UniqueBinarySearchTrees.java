package leetcode;

public class UniqueBinarySearchTrees {

  public int numTrees(int n) {
    if (n < 3) {
      return n;
    }
    int[] ints = new int[n + 1];
    ints[0] = 1;
    ints[1] = 1;
    ints[2] = 2;

    for (int i = 3; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        ints[i] += ints[j - 1] * ints[i - j];
      }
    }

    return ints[n];
  }
}
