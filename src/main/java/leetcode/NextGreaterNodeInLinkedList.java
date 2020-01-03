package leetcode;

import java.util.LinkedList;
import model.ListNode;

public class NextGreaterNodeInLinkedList {

  public int[] nextLargerNodes(ListNode head) {
    int count = 0;
    ListNode tmp = head;
    while (tmp != null) {
      count++;
      tmp = tmp.next;
    }
    int[] result = new int[count];
    for (int i = 0; i < count; i++) {
      result[i] = head.val;
      head = head.next;
    }

    LinkedList<Integer> stack = new LinkedList<>();
    for (int i = result.length - 1; i >= 0; i--) {
      int val = result[i];

      while (!stack.isEmpty() && val >= stack.peek()) {
        stack.pop();
      }
      result[i] = stack.isEmpty() ? result[i] = 0 : stack.peek();
      stack.push(val);
    }

    return result;
  }

}
