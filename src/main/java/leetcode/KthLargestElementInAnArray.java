package leetcode;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray {

  public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> queue = new PriorityQueue<>(k);
    for (int i : nums) {
      if (queue.size() < k) {
        queue.add(i);
      } else {
        if (queue.peek() < i) {
          queue.poll();
          queue.add(i);
        }
      }
    }
    return queue.peek();
  }
}
