package leetcode;

public class DesignCircularDeque {

  class MyCircularDeque {

    private final int limit;

    private int size;

    private Node head, tail;


    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
      limit = k;
      size = 0;
      head = new Node(-1);
      tail = new Node(-1);
      head.next = tail;
      tail.prev = head;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
      if (isFull()) {
        return false;
      }

      Node newNode = new Node(value);
      Node oldNext = head.next;

      newNode.next = oldNext;
      oldNext.prev = newNode;

      head.next = newNode;
      newNode.prev = head;

      size++;

      return true;

    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
      if (isFull()) {
        return false;
      }

      Node newNode = new Node(value);
      Node oldPrev = tail.prev;

      oldPrev.next = newNode;
      newNode.prev = oldPrev;

      tail.prev = newNode;
      newNode.next = tail;

      size++;

      return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
      if (isEmpty()) {
        return false;
      }

      head.next = head.next.next;
      head.next.prev = head;

      size--;
      return true;

    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
      if (isEmpty()) {
        return false;
      }

      tail.prev = tail.prev.prev;
      tail.prev.next = tail;

      size--;
      return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {

      return head.next.val;

    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
      return tail.prev.val;
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
      return size == 0;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
      return size >= limit;
    }

    private class Node {

      Node prev, next;

      int val;

      private Node(int val) {
        this.val = val;
      }
    }

  }
}
