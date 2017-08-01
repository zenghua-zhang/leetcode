package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.junit.Test;

public class MinimumIndexSumofTwoLists {

  public String[] findRestaurant(String[] list1, String[] list2) {
    Map<String, Integer> map1 = new HashMap<>();
    for (int i = 0; i < list1.length; i++) {
      map1.put(list1[i], i);
    }

    Map<String, Integer> map2 = new HashMap<>();
    for (int i = 0; i < list2.length; i++) {
      map2.put(list2[i], i);
    }

    Map<String, Integer> map3 = new HashMap<>();
    for (Entry<String, Integer> e : map1.entrySet()) {
      String key = e.getKey();
      if (map2.containsKey(key)) {
        map3.put(key, e.getValue() + map2.get(key));
      }
    }

    int min = Integer.MAX_VALUE;
    for (int i : map3.values()) {
      min = Math.min(i, min);
    }

    List<String> list = new ArrayList<>();
    for (Entry<String, Integer> e : map3.entrySet()) {
      if (e.getValue() == min) {
        list.add(e.getKey());
      }
    }

    return list.toArray(new String[list.size()]);
  }

  @Test
  public void test() {
    MinimumIndexSumofTwoLists t = new MinimumIndexSumofTwoLists();
    String[] l1 = new String[]{"Shogun", "KFC", "Tapioca Express", "Burger King"};
    String[] l2 = new String[]{"KFC", "Shogun", "Burger King"};
    System.out.println(Arrays.deepToString(t.findRestaurant(l1, l2)));

  }
}
