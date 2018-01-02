package model;

public class ListNode {

  public int val;

  public int getVal() {
    return val;
  }

  public void setVal(int val) {
    this.val = val;
  }

  public ListNode getNext() {
    return next;
  }

  public void setNext(ListNode next) {
    this.next = next;
  }

  public ListNode next;

  public ListNode(int x) {
    val = x;
    next = null;
  }
}
