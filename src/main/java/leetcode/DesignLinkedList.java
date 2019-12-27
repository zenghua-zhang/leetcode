package leetcode;

public class DesignLinkedList {

  class MyLinkedList {

    private Node head;

    private int size = 0;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
      if (index >= size || index < 0) {
        return -1;
      }
      Node tmp = head;
      while (index-- > 0) {
        tmp = tmp.next;
      }
      return tmp.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be
     * the first node of the linked list.
     */
    public void addAtHead(int val) {
      head = new Node(val, head);
      size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
      Node tail = new Node(val, null);
      Node tmp = head;
      if (tmp == null) {
        head = tail;
        size++;
        return;
      }
      while (tmp.next != null) {
        tmp = tmp.next;
      }
      tmp.next = tail;
      size++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked
     * list, the node will be appended to the end of linked list. If index is greater than the length, the node will not
     * be inserted.
     */
    public void addAtIndex(int index, int val) {
      if (index > size || index < 0) {
        return;
      }
      if (index == 0) {
        addAtHead(val);
        return;
      }
      Node tmp = head;
      while (--index > 0) {
        tmp = tmp.next;
      }

      Node next = tmp.next;
      tmp.next = new Node(val, next);
      size++;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
      if (index >= size || index < 0) {
        return;
      }
      if (index == 0) {
        head = head.next;
        size--;
        return;
      }
      Node tmp = head;
      while (--index > 0) {
        tmp = tmp.next;
      }
      tmp.next = tmp.next.next;
      size--;
    }

    private class Node {

      private Node next;

      private int val;

      private Node(int val, Node next) {
        this.next = next;
        this.val = val;
      }
    }


  }

}
