package leetcode;

public class FindSmallestLetterGreaterThanTarget {

  public char nextGreatestLetter(char[] letters, char target) {
    if (target >= letters[letters.length - 1] || target < letters[0]) {
      return letters[0];
    }
    for (char c : letters) {
      if (c > target) {
        return c;
      }
    }
    return letters[0];
  }
}
