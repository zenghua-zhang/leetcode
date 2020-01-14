package leetcode;

public class SatisfiabilityOfEqualityEquations {

  public boolean equationsPossible(String[] equations) {

    UnionFind uf = new UnionFind();

    for (String equation : equations) {
      if (equation.charAt(1) == '!') {
        continue;
      }
      uf.union(equation.charAt(0) - 'a', equation.charAt(3) - 'a');
    }
    for (String equation : equations) {
      if (equation.charAt(1) == '=') {
        continue;
      }
      int left = equation.charAt(0)- 'a';
      int right = equation.charAt(3)- 'a';

      if (uf.findRoot(left) == uf.findRoot(right)) {
        return false;
      }

    }

    return true;
  }

  private static class UnionFind {

    private final int[] ids;

    private final int[] size;

    private UnionFind() {
      ids = new int[26];
      size = new int[26];

      for (int i = 0; i < 26; i++) {
        ids[i] = i;
        size[i] = 1;
      }

    }

    private int findRoot(int p) {
      while (p != ids[p]) {
        ids[p] = ids[ids[p]];
        p = ids[p];
      }
      return p;
    }

    private void union(int s, int d) {
      int sRoot = findRoot(s);
      int dRoot = findRoot(d);

      if (sRoot == dRoot) {
        return;
      }

      if (size[sRoot] > size[dRoot]) {
        ids[dRoot] = sRoot;
        size[sRoot] += size[dRoot];
      } else {
        ids[sRoot] = dRoot;
        size[dRoot] += size[sRoot];
      }

    }
  }

  public static void main(String[] args) {
    System.out.println((char) (98));
  }
}
