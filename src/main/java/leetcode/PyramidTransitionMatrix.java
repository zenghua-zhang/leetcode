package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class PyramidTransitionMatrix {

  public boolean pyramidTransition(String bottom, List<String> allowed) {

    Map<Point, List<Character>> map = new HashMap<>();

    for (String s : allowed) {
      char[] cs = s.toCharArray();

      Point point = new Point(cs[0], cs[1]);
      List<Character> list = map.get(point);
      if (list == null) {
        list = new ArrayList<>();
      }
      list.add(cs[2]);

      map.put(point, list);
    }

    return helper(bottom.toCharArray(), map);
  }

  private boolean helper(char[] chars, Map<Point, List<Character>> map) {
    if (chars.length <= 1) {
      return true;
    }

    List<StringBuilder> lists = new ArrayList<>();
    for (int i = 1; i < chars.length; i++) {
      Point p = new Point(chars[i - 1], chars[i]);
      List<Character> characters = map.get(p);
      if (characters == null) {
        return false;
      }

      if (lists.size() == 0) {
        for (Character character : characters) {
          StringBuilder sb = new StringBuilder();
          sb.append(character);
          lists.add(sb);
        }
      } else {
        List<StringBuilder> tmp = new ArrayList<>();
        for (StringBuilder sb : lists) {
          for (Character character : characters) {
            StringBuilder newSb = new StringBuilder();
            newSb.append(sb).append(character);
            tmp.add(newSb);
          }
        }
        lists = tmp;
      }
    }

    for (StringBuilder list : lists) {
      if (helper(list.toString().toCharArray(), map)) {
        return true;
      }
    }

    return false;
  }

  class Point {

    private Character left;
    private Character right;

    public Point(Character left, Character right) {
      this.left = left;
      this.right = right;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Point point = (Point) o;
      return Objects.equals(left, point.left) &&
          Objects.equals(right, point.right);
    }

    @Override
    public int hashCode() {

      return Objects.hash(left, right);
    }
  }


}
