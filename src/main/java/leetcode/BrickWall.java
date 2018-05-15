package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BrickWall {

  public int leastBricks(List<List<Integer>> wall) {
    //timeout
    int ret = wall.size();
    List<Set<Integer>> sets = new ArrayList<>();
    Set<Integer> edges = new HashSet<>();

    for (List<Integer> list : wall) {
      int tmp = 0;
      Set<Integer> set = new HashSet<>();
      for (int i = 0; i < list.size() - 1; i++) {
        tmp += list.get(i);
        set.add(tmp);
        edges.add(tmp);
      }
      sets.add(set);
    }

    for (Integer edge : edges) {
      int t = 0;
      for (Set<Integer> set : sets) {
        if (!set.contains(edge)) {
          t++;
        }
      }
      ret = Math.min(t, ret);
    }

    return ret;
  }
}
