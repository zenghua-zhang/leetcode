package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import org.junit.Test;

public class TopKFrequentElements {

  public List<Integer> topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int n : nums) {
      int j = map.getOrDefault(n, 0);
      map.put(n, j + 1);
    }

    PriorityQueue<Node> priorityQueue = new PriorityQueue<>();

    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      priorityQueue.add(new Node(entry));
      if (priorityQueue.size() > k) {
        priorityQueue.poll();
      }
    }
    List<Integer> list = new ArrayList<>();
    for (Node n : priorityQueue) {
      list.add(n.num);


    }

    return list;
  }

  private class Node implements Comparable {

    private int num;

    private int frequent;

    private Node(Map.Entry<Integer, Integer> entry) {
      this.num = entry.getKey();
      this.frequent = entry.getValue();
    }

    @Override
    public int compareTo(Object o) {
      Node n = (Node) o;
      return this.frequent - n.frequent;
    }

  }

  @Test
  public void test() {
    TopKFrequentElements top = new TopKFrequentElements();
    System.out.println(top.topKFrequent(new int[]{1, 2, 1, 2, 3, 1, 3, 3, 3, 3, 3}, 2));
  }
}
