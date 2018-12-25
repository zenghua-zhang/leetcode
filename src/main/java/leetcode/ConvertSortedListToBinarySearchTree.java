package leetcode;

import model.ListNode;
import model.TreeNode;

public class ConvertSortedListToBinarySearchTree {

  public TreeNode sortedListToBST(ListNode head) {
    if (head == null) {
      return null;
    }
    if (head.next == null) {
      return new TreeNode(head.val);
    }

    ListNode slow = head;
    ListNode fast = head.next;

    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    ListNode next = slow.next;
    TreeNode root = new TreeNode(next.val);
    slow.next = null;
    root.left = sortedListToBST(head);
    root.right = sortedListToBST(next.next);

    return root;
  }

}
