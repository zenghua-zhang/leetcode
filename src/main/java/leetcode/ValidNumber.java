package leetcode;

public class ValidNumber {

  public boolean isNumber(String s) {
    if (s == null) {
      return false;
    }

    s = s.trim();

    if ("".equals(s)) {
      return false;
    }

    int eIndex = -1;

    for (int i = 0; i < s.toCharArray().length; i++) {
      char c = s.charAt(i);

      if ((c >= '0' && c <= '9') || c == '+' || c == '-' || c == '.') {
        continue;
      }

      if (c == 'e' && eIndex == -1) {
        eIndex = i;
        continue;
      }

      return false;
    }

    if (eIndex == -1) {
      return isNumberContainsPoint(s);
    }

    return isNumberContainsPoint(s.substring(0, eIndex)) && isNumberWithoutPoint(s.substring(eIndex + 1));
  }

  private boolean isNumberWithoutPoint(String s) {

    if (null == s || s.length() == 0) {
      return false;
    }
    char startChar = s.charAt(0);

    int start = startChar == '+' || startChar == '-' ? 1 : 0;

    if (start == 1 && s.length() == 1) {
      return false;
    }

    return isStrAllNumbers(s.substring(start));
  }

  private boolean isNumberContainsPoint(String s) {
    if (null == s || s.length() == 0) {
      return false;
    }

    int pointIndex = -1;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '.') {
        pointIndex = i;
        break;
      }
    }

    if (pointIndex == -1) {
      return isNumberWithoutPoint(s);
    }

    String left = s.substring(0, pointIndex);
    String right = s.substring(pointIndex + 1);

    if (left.length() == 0) {
      return isStrAllNumbers(right);
    }
    if (left.charAt(0) == '+' || left.charAt(0) == '-') {
      left = left.substring(1);
    }
    if (left.length() == 0) {
      return isStrAllNumbers(right);
    }

    if (right.length() == 0) {
      return isNumberWithoutPoint(left);
    }

    return isStrAllNumbers(left) && isStrAllNumbers(right);
  }

  private boolean isStrAllNumbers(String s) {

    if (null == s || s.length() == 0) {
      return false;
    }

    for (int i = 0; i < s.toCharArray().length; i++) {
      char c = s.charAt(i);

      if (c >= '0' && c <= '9') {
        continue;
      }

      return false;
    }

    return true;
  }

}
