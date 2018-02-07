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

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj == null && this == null) {
      return true;
    }
    ListNode n = (ListNode) obj;
    if (n.getVal() != this.getVal()) {
      return false;
    }
    if (n.getNext() == null && this.getNext() == null) {
      return true;
    }
    if (n.getNext() != null && this.getNext() == null) {
      return false;
    }
    if (n.getNext() == null && this.getNext() != null) {
      return false;
    }

    return n.getNext().equals(this.getNext());
  }
}
