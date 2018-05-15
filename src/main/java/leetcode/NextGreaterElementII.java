package leetcode;

import java.util.Stack;

public class NextGreaterElementII {

  public int[] nextGreaterElements(int[] nums) {
    if (nums.length == 0) {
      return nums;
    }
    int[] ret = new int[nums.length];
    int max = Integer.MIN_VALUE;
    int maxPos = -1;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > max) {
        max = nums[i];
        maxPos = i;
      }
    }

    ret[maxPos] = -1;
    int pos = maxPos - 1;
    Stack<Integer> stack = new Stack<>();
    stack.push(max);
    while ((pos = (pos < 0 ? nums.length - 1 : pos)) != maxPos) {
      int value = nums[pos];

      if (value != max) {
        while (!stack.isEmpty() && stack.peek() <= value) {
          stack.pop();
        }
        ret[pos] = stack.peek();
      } else {
        ret[pos] = -1;
        stack.clear();
      }
      stack.push(value);
      pos--;
    }

    return ret;
  }
}
