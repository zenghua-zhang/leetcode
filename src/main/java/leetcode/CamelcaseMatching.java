package leetcode;

import java.util.ArrayList;
import java.util.List;

public class CamelcaseMatching {

  public List<Boolean> camelMatch(String[] queries, String pattern) {
    List<Boolean> result = new ArrayList<>();
    List<String> patterns = findCamelList(pattern);

    for (String query : queries) {
      List<String> camels = findCamelList(query);
      result.add(matches(camels, patterns));
    }

    return result;
  }

  private boolean matches(List<String> query, List<String> pattern) {
    if (startsWithLowerCase(query.get(0)) && !startsWithLowerCase(pattern.get(0))) {
      query.remove(0);
    }

    if (query.size() != pattern.size()) {
      return false;
    }

    for (int i = 0; i < query.size(); i++) {
      String qu = query.get(i);
      String pa = pattern.get(i);
      if (!matches(qu, pa)) {
        return false;
      }
    }

    return true;
  }

  private boolean startsWithLowerCase(String s) {
    char c = s.charAt(0);
    return c >= 'a' && c <= 'z';
  }

  private boolean matches(String query, String pattern) {
    char[] queryChars = query.toCharArray();
    char[] patternChars = pattern.toCharArray();

    int patternIndex = 0;

    for (char c : queryChars) {
      if (c == patternChars[patternIndex]) {
        patternIndex++;
      }

      if (patternIndex >= patternChars.length) {
        return true;
      }
    }

    return false;
  }

  private List<String> findCamelList(String s) {
    List<String> list = new ArrayList<>();
    if (s == null || s.length() == 0) {
      return list;
    }
    StringBuilder sb = new StringBuilder();
    sb.append(s.charAt(0));

    for (int i = 1; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c >= 'A' && c <= 'Z') {
        list.add(sb.toString());
        sb = new StringBuilder();
        sb.append(c);
      } else {
        sb.append(c);
      }
    }

    list.add(sb.toString());

    return list;
  }


}
