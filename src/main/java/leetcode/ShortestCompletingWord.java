package leetcode;

import java.util.Arrays;

public class ShortestCompletingWord {

  public String shortestCompletingWord(String licensePlate, String[] words) {
    int[] licenses = new int[26];
    for (char c : licensePlate.toCharArray()) {
      if (c >= 'A' && c <= 'Z') {
        licenses[c - 'A']++;
      } else if (c >= 'a' && c <= 'z') {
        licenses[c - 'a']++;
      }
    }
    String ret = null;
    for (String word : words) {
      int[] copy = Arrays.copyOf(licenses, 26);

      for (char c : word.toCharArray()) {
        if (c >= 'A' && c <= 'Z') {
          copy[c - 'A']--;
        } else if (c >= 'a' && c <= 'z') {
          copy[c - 'a']--;
        }
      }
      if (notContainPositive(copy)) {
        if (null == ret || ret.length() > word.length()) {
          ret = word;
        }
      }
    }

    return ret;
  }

  private boolean notContainPositive(int[] ints) {
    for (int i : ints) {
      if (i > 0) {
        return false;
      }
    }
    return true;
  }


}
