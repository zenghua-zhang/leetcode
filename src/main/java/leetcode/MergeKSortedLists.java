package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import model.ListNode;

public class MergeKSortedLists {

  public ListNode mergeKLists(ListNode[] lists) {
    if (lists.length == 0) {
      return null;
    }
    PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(Comparator.comparing(listNode -> listNode.val));

    for (ListNode list : lists) {
      if (list != null) {
        priorityQueue.add(list);
      }
    }
    if (priorityQueue.isEmpty()) {
      return null;
    }

    ListNode head = priorityQueue.poll();

    if (head.next != null) {
      priorityQueue.add(head.next);
    }

    ListNode tmp = head;

    while (!priorityQueue.isEmpty()) {
      ListNode next = priorityQueue.poll();
      tmp.next = next;
      tmp = next;

      if (next.next != null) {
        priorityQueue.add(next.next);
      }
    }

    return head;
  }
}
