package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DistantBarcodes {

  public int[] rearrangeBarcodes(int[] barcodes) {
    if (barcodes.length <= 2) {
      return barcodes;
    }
    int[] result = new int[barcodes.length];

    Map<Integer, Integer> countMap = new HashMap<>();

    for (int barcode : barcodes) {
      int count = countMap.getOrDefault(barcode, 0);
      countMap.put(barcode, count + 1);
    }

    PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(countMap.size(),
        (o1, o2) -> o2[1] - o1[1]);

    for (Map.Entry<Integer, Integer> e : countMap.entrySet()) {
      priorityQueue.add(new int[]{e.getKey(), e.getValue()});
    }

    int previous = 0;

    for (int i = 0; i < barcodes.length; i++) {
      int[] tmp = priorityQueue.poll();

      if (previous != tmp[0]) {
        result[i] = tmp[0];
        tmp[1]--;
      } else {
        int[] second = priorityQueue.poll();
        result[i] = second[0];
        second[1]--;

        if (second[1] > 0) {
          priorityQueue.add(second);
        }
      }

      if (tmp[1] > 0) {
        priorityQueue.add(tmp);
      }

      previous = result[i];
    }

    return result;
  }

  public static void main(String[] args) {
    DistantBarcodes db = new DistantBarcodes();
    System.out.println(Arrays.toString(db.rearrangeBarcodes(new int[]{1, 1, 1, 1, 2, 2, 3, 3})));
  }

}
