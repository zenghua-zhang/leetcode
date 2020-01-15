package leetcode;

import java.util.Arrays;

public class PermutationInString {

  public boolean checkInclusion(String s1, String s2) {
    int l1 = s1.length();
    int l2 = s2.length();

    if (l1 > l2) {
      return false;
    }

    int[] s1Index = getIndex(s1);

    for (int i = 0; i <= l2 - l1; i++) {
      int[] tmpIndex = getIndex(s2.substring(i, i + l1));
      if (equals(s1Index, tmpIndex)) {
        return true;
      }
    }

    return false;
  }

  private boolean equals(int[] p, int[] r) {
    for (int i = 0; i < 26; i++) {
      if (p[i] != r[i]) {
        return false;
      }
    }
    return true;
  }


  private int[] getIndex(String s) {
    int[] index = new int[26];

    for (char c : s.toCharArray()) {
      index[c - 'a']++;
    }

    return index;
  }

}
