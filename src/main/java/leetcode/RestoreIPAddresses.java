package leetcode;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {

  private List<String> result;

  private String ip;

  public List<String> restoreIpAddresses(String s) {

    result = new ArrayList<>();
    ip = s;

    helper(new ArrayList<>(), 0);

    return result;
  }

  private void helper(List<String> list, int pos) {
    if (list.size() > 4) {
      return;
    }

    if (!list.isEmpty() && !validate(list.get(list.size() - 1))) {
      return;
    }

    if (pos == ip.length()) {
      if (list.size() == 4) {
        result.add(String.join(".", list));
      }
      return;
    }

    for (int i = 0; i < 3 && pos + i < ip.length(); i++) {
      list.add(ip.substring(pos, pos + i + 1));
      helper(list, pos + i + 1);
      list.remove(list.size() - 1);
    }
  }

  private boolean validate(String s) {
    if (s.charAt(0) == '0' && s.length() != 1) {
      return false;
    }

    int num = Integer.parseInt(s);
    return num <= 255;
  }
}
