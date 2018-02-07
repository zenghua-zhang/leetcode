package leetcode;

import model.ListNode;

public class OddEvenLinkedList {

  public ListNode oddEvenList(ListNode head) {
    ListNode odd = new ListNode(0);
    ListNode even = new ListNode(0);
    ListNode oddHead = odd;
    ListNode evenHead = even;

    int s = 1;
    while (null != head) {
      ListNode tmp = head.next;
      head.next = null;
      if ((s & 1) == 1) {
        odd.next = head;
        odd = odd.next;
      } else {
        even.next = head;
        even = even.next;
      }
      head = tmp;
      s++;
    }
    odd.next = evenHead.next;

    return oddHead.next;
  }
}
