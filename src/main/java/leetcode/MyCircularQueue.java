package leetcode;

import java.util.LinkedList;

public class MyCircularQueue {

  LinkedList<Integer> list;

  private final int max;

  /**
   * Initialize your data structure here. Set the size of the queue to be k.
   */
  public MyCircularQueue(int k) {
    if (k < 1) {
      throw new IllegalArgumentException();
    }

    list = new LinkedList<>();

    max = k;
  }

  /**
   * Insert an element into the circular queue. Return true if the operation is successful.
   */
  public boolean enQueue(int value) {
    if (isFull()) {
      return false;
    }
    list.add(value);
    return true;
  }

  /**
   * Delete an element from the circular queue. Return true if the operation is successful.
   */
  public boolean deQueue() {
    if (isEmpty()) {
      return false;
    }

    list.removeFirst();
    return true;

  }

  /**
   * Get the front item from the queue.
   */
  public int Front() {
    return isEmpty() ? -1 : list.peekFirst();
  }

  /**
   * Get the last item from the queue.
   */
  public int Rear() {
    return isEmpty() ? -1 : list.peekLast();
  }

  /**
   * Checks whether the circular queue is empty or not.
   */
  public boolean isEmpty() {
    return list.isEmpty();
  }

  /**
   * Checks whether the circular queue is full or not.
   */
  public boolean isFull() {
    return list.size() == max;
  }

}
