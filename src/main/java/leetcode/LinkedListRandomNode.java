package leetcode;

import java.util.Random;
import model.ListNode;

public class LinkedListRandomNode {

  class Solution {

    private ListNode head;

    private int size;

    private Random random;

    /**
     * @param head The linked list's head. Note that the head is guaranteed to be not null, so it contains at least one
     * node.
     */
    public Solution(ListNode head) {
      int n = 0;
      this.head = head;
      ListNode tmp = head;
      while (tmp != null) {
        tmp = tmp.next;
        n++;
      }
      size = n;
      random = new Random();
    }

    /**
     * Returns a random node's value.
     */
    public int getRandom() {
      ListNode tmp = head;
      for (int i = 0; i < size; i++) {
        int r = random.nextInt(size - i);
        if (r == 0) {
          return tmp.val;
        }
        tmp = tmp.next;
      }

      return 0;
    }
  }

  public static void main(String[] args) {
  }
}
