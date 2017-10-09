package leetcode;

public class FindtheDifference {

  public char findTheDifference(String s, String t) {
    int[] chars = new int[26];
    for (char c : t.toCharArray()) {
      chars[c - 'a']++;
    }
    for (char c : s.toCharArray()) {
      chars[c - 'a']--;
    }

    char r = 'a';
    for (int i = 0; i < 26; i++) {
      if (chars[i] != 0) {
        r = (char) ('a' + i);
      }
    }

    return r;
  }
}
