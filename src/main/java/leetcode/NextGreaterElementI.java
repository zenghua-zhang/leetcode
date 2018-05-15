package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementI {

  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    int[] ret = new int[nums1.length];
    Stack<Integer> stack = new Stack<>();
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = nums2.length - 1; i >= 0; i--) {
      int tmp = nums2[i];
      while (!stack.isEmpty()) {
        if (stack.peek() < tmp) {
          stack.pop();
        } else {
          map.put(tmp, stack.peek());
          break;
        }
      }
      stack.push(tmp);
    }

    for (int i = 0; i < nums1.length; i++) {
      ret[i] = map.getOrDefault(nums1[i], -1);
    }

    return ret;
  }
}
