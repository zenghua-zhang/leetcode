package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ReverseWordsInAString {

  public String reverseWords(String s) {
    LinkedList<String> list = new LinkedList<>();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (Character.isSpaceChar(c)) {
        if (sb.length() == 0) {
          continue;
        }
        list.add(sb.toString());
        sb = new StringBuilder();
      } else {
        sb.append(c);
      }
    }
    if (sb.length() != 0) {
      list.add(sb.toString());
    }

    List<String> l = new ArrayList<>(list.size());
    while (!list.isEmpty()) {
      l.add(list.removeLast());
    }

    return String.join(" ", l);
  }
}
