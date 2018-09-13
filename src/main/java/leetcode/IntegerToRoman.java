package leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {

  public String intToRoman(int num) {
    Map<Integer, String> thousand = new HashMap<>();
    thousand.put(0, "");
    for (int i = 1; i < 4; i++) {
      thousand.put(i, String.join("", Collections.nCopies(i, "M")));
    }

    Map<Integer, String> hundreds = genMap("C", "D", "M");
    Map<Integer, String> tens = genMap("X", "L", "C");
    Map<Integer, String> units = genMap("I", "V", "X");

    StringBuilder sb = new StringBuilder();
    sb.append(thousand.get(num / 1000));
    num = num % 1000;
    sb.append(hundreds.get(num / 100));
    num = num % 100;
    sb.append(tens.get(num / 10));
    num = num % 10;
    sb.append(units.get(num));

    return sb.toString();
  }

  private Map<Integer, String> genMap(String n, String five, String ten) {
    Map<Integer, String> map = new HashMap<>();
    map.put(0, "");
    map.put(1, n);
    map.put(2, n + n);
    map.put(3, n + n + n);
    map.put(4, n + five);
    map.put(5, five);
    map.put(6, five + n);
    map.put(7, five + n + n);
    map.put(8, five + n + n + n);
    map.put(9, n + ten);

    return map;
  }
}
