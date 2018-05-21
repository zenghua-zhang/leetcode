package leetcode;

import java.util.Map;
import java.util.TreeMap;

public class MostProfitAssigningWork {

  public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
    if (worker.length == 0) {
      return 0;
    }

    TreeMap<Integer, Integer> map = new TreeMap<>();
    for (int i = 0; i < difficulty.length; i++) {
      int v = profit[i];
      if (map.containsKey(difficulty[i])) {
        v = Math.max(v, map.get(difficulty[i]));
      }
      map.put(difficulty[i], v);
    }

    Integer tmp = Integer.MIN_VALUE;

    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      tmp = Math.max(entry.getValue(), tmp);
      entry.setValue(tmp);
    }

    int sum = 0;

    for (int i : worker) {
      if (map.floorKey(i) != null) {
        int value = map.floorEntry(i).getValue();
        sum += map.floorEntry(i).getValue();
      } else {
      }
    }

    return sum;

  }

  public static void main(String[] args) {
    TreeMap<Integer, String> map = new TreeMap<>();
    for (int i = 10; i > 0; i--) {
      map.put(i * 2, i + "");
    }
    for (Map.Entry<Integer, String> entry : map.entrySet()) {
      entry.setValue("+" + entry.getValue());
    }

    System.out.println(map.ceilingEntry(4));

  }
}
