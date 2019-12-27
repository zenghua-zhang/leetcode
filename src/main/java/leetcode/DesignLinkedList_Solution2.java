package leetcode;

// design for 2 direction Node
public class DesignLinkedList_Solution2 {

  class MyLinkedList {

    private Node head;

    private Node tail;

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
      return getByIndex(index).val;
    }

    private Node getByIndex(int index) {
      boolean fromTail = size / 2 < index;
      if (fromTail) {
        Node tmp = tail;
        while (++index < size) {
          tmp = tmp.prev;
        }
        return tmp;
      } else {
        Node tmp = head;

        while (index-- > 0) {
          tmp = tmp.next;
        }
        return tmp;
      }
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be
     * the first node of the linked list.
     */
    public void addAtHead(int val) {
      head = new Node(null, head, val);
      if (tail == null) {
        tail = head;
      }
      size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
      tail = new Node(tail, null, val);
      if (head == null) {
        head = tail;
      }
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
      if (index == size) {
        addAtTail(val);
        return;
      }
      Node tmp = getByIndex(index);
      new Node(tmp.prev, tmp, val);
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
        if (head != null) {
          head.prev = null;
        }
      } else if (index == size - 1) {
        tail = tail.prev;
        tail.next = null;
      } else {
        Node tmp = getByIndex(index);
        tmp.prev.next = tmp.next;
        tmp.next.prev = tmp.prev;
      }

      size--;
    }


    private class Node {

      private Node prev;

      private Node next;

      private int val;

      private Node(Node prev, Node next, int val) {
        this.prev = prev;
        this.next = next;
        this.val = val;

        if (prev != null) {
          prev.next = this;
        }
        if (next != null) {
          next.prev = this;
        }
      }
    }


  }

}
