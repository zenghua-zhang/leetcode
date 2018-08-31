package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequentWords {

  public List<String> topKFrequent(String[] words, int k) {
    Map<String, Integer> map = new HashMap<>();
    for (String word : words) {
      Integer v = map.getOrDefault(word, 0) + 1;
      map.put(word, v);
    }

    Comparator<Map.Entry<String, Integer>> c = (o1, o2) -> {
      if (o1.getValue().compareTo(o2.getValue()) == 0) {
        return o2.getKey().compareTo(o1.getKey());
      } else {
        return o1.getValue().compareTo(o2.getValue());
      }
    };

    Queue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(c);

    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      queue.add(entry);
      if (queue.size() > k) {
        queue.poll();
      }
    }

    List<String> ret = new ArrayList<>(k);
    while (!queue.isEmpty()) {
      ret.add(queue.poll().getKey());
    }

    Collections.reverse(ret);

    return ret;
  }
}
