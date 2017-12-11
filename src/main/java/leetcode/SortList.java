package leetcode;

import org.junit.Test;

public class SortList {

  public ListNode sortList(ListNode head) {
    if (null == head || null == head.next) {
      return head;
    }
    ListNode greater = new ListNode(0);
    ListNode gtmp = greater;
    ListNode less = new ListNode(0);
    ListNode ltmp = less;

    ListNode tmp = head.next;

    ListNode htmp = head;

    while (null != tmp) {
      ListNode tt = tmp;
      tmp = tmp.next;
      tt.next = null;
      if (tt.val == head.val) {
        htmp.next = tt;
        htmp = htmp.next;
      } else if (tt.val > head.val) {
        gtmp.next = tt;
        gtmp = gtmp.next;
      } else {
        ltmp.next = tt;
        ltmp = ltmp.next;
      }
    }

    less = sortList(less.next);
    ListNode tail = less;
    if (tail != null) {
      while (tail.next != null) {
        tail = tail.next;
      }
      tail.next = head;

    } else {
      less = head;
    }

    htmp.next = sortList(greater.next);

    return less;
  }

  @Test
  public void test() {
    ListNode root = new ListNode(2);
    ListNode node1 = new ListNode(3);
    ListNode node2 = new ListNode(1);
    root.next = node1;
    node1.next = node2;

    new SortList().sortList(root);
  }
}
