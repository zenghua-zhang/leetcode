package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

  public int lengthOfLongestSubstring(String s) {
    if (null == s || "".equals(s.trim())) {
      return 0;
    }
    Set<Character> chars = new HashSet<>();

    int max = Integer.MIN_VALUE;
    int start = 0;

    for (int end = 0; end < s.length(); end++) {
      if (chars.contains(s.charAt(end))) {
        max = Math.max(end - start, max);
        while (s.charAt(start) != s.charAt(end)) {
          chars.remove(s.charAt(start));
          start++;
        }
        chars.remove(s.charAt(start));
        start++;
      }

      chars.add(s.charAt(end));
    }

    max = Math.max(s.length() - start, max);

    return max;
  }

}
