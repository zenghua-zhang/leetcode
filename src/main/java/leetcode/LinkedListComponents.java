package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import model.ListNode;
import org.junit.Test;

public class LinkedListComponents {

  public int numComponents(ListNode head, int[] G) {
    Map<Integer, Integer> map = new HashMap<>();
    while (null != head && null != head.next) {
      map.put(head.val, head.next.val);
      head = head.next;
    }

    boolean[] gs = new boolean[10001];
    Arrays.fill(gs, false);
    for (int g : G) {
      gs[g] = true;
    }

    for (int i = 0; i <= 10000; i++) {
      if (gs[i]) {
        remove(gs, map, i);
      }
    }

    int ret = 0;
    for (int i = 0; i <= 10000; i++) {
      if (gs[i]) {
        ret++;

      }
    }
    return ret;
  }

  private void remove(boolean[] gs, Map<Integer, Integer> map, int pos) {
    Integer nextPos = map.get(pos);
    if (null != nextPos) {
      boolean nextValue = gs[nextPos];
      gs[nextPos] = false;
      if (nextValue) {
        remove(gs, map, nextPos);
      }
    }
  }
}
