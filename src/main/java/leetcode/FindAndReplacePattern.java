package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindAndReplacePattern {

  public List<String> findAndReplacePattern(String[] words, String pattern) {
    return Arrays.stream(words).filter(s -> match(s, pattern)).collect(Collectors.toList());
  }

  boolean match(String word, String pattern) {
    if (word.length() != pattern.length()) {
      return false;
    }
    Map<Character, Character> wordToPattern = new HashMap<>();
    Map<Character, Character> patternToWord = new HashMap<>();

    for (int i = 0; i < word.length(); i++) {
      char w = word.charAt(i);
      char p = pattern.charAt(i);

      if (wordToPattern.containsKey(w)) {
        if (wordToPattern.get(w) != p) {
          return false;
        }
      }

      if (patternToWord.containsKey(p)) {
        if (patternToWord.get(p) != w) {
          return false;
        }
      }

      wordToPattern.put(w, p);
      patternToWord.put(p, w);

    }

    return true;

  }
}
