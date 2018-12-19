package leetcode;

import java.util.Comparator;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.function.BiFunction;

public class ArrayOfDoubledPairs {

  public boolean canReorderDoubled(int[] A) {
    TreeMap<Integer, Integer> positive = new TreeMap<>(Comparator.naturalOrder());
    TreeMap<Integer, Integer> negative = new TreeMap<>(Comparator.reverseOrder());
    BiFunction<Integer, Integer, Integer> fun = (key, oldValue) -> {
      if (oldValue == null) {
        return 1;
      } else {
        return oldValue + 1;
      }
    };
    int zeros = 0;

    for (int i : A) {
      if (i == 0) {
        zeros++;
      } else if (i < 0) {
        negative.compute(i, fun);
      } else {
        positive.compute(i, fun);
      }
    }

    if ((zeros & 1) == 1) {
      return false;
    }

    return checkMap(positive) && checkMap(negative);
  }

  private boolean checkMap(TreeMap<Integer, Integer> map) {

    for (Entry<Integer, Integer> entry : map.entrySet()) {
      if (entry.getValue() == 0) {
        continue;
      }
      int v = entry.getValue();

      int target = entry.getKey() * 2;
      if (!map.containsKey(target)) {
        return false;
      }
      int targetCount = map.get(target);
      if (map.get(target) - v < 0) {
        return false;
      }
      entry.setValue(0);
      map.put(target, targetCount - v);
    }

    return true;
  }
}
