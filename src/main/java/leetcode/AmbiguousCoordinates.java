package leetcode;

import java.util.ArrayList;
import java.util.List;

public class AmbiguousCoordinates {

  public List<String> ambiguousCoordinates(String S) {
    List<String> result = new ArrayList<>();

    if (S.length() == 3) {
      return result;
    }
    for (int i = 1; i < S.length() - 2; i++) {
      String left = S.substring(1, i + 1);
      String right = S.substring(i + 1, S.length() - 1);

      for (String l : helper(left)) {
        for (String r : helper(right)) {
          result.add("(" + l + ", " + r + ")");
        }
      }
    }
    return result;
  }

  private List<String> helper(String str) {
    List<String> list = new ArrayList<>();
    if (str.length() == 1) {
      list.add(str);
      return list;
    }

    if (!str.startsWith("0")) {
      list.add(str);
    }
    for (int i = 0; i < str.length() - 1; i++) {
      String left = str.substring(0, i + 1);
      String right = str.substring(i + 1);

      String num = getNumericStr(left, right);
      if (!"".equals(num)) {
        list.add(num);
      }
    }

    return list;
  }

  private String getNumericStr(String l, String r) {
    if (l.length() > 1 && l.startsWith("0")) {
      return "";
    }
    if (r.endsWith("0")) {
      return "";
    }
    return l + "." + r;
  }

}
