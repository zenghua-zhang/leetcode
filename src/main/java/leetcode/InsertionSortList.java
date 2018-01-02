package leetcode;

import model.ListNode;

public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        ListNode sorted = new ListNode(Integer.MIN_VALUE);
        helper(sorted, head);
        return sorted.next;
    }

    private void helper(ListNode sorted, ListNode head) {
        if (head == null) {
            return;
        }
        ListNode root = sorted;
        ListNode next = head.next;

        while (sorted != null) {
            if (sorted.next == null) {
                sorted.next = head;
                head.next = null;
                break;
            }
            int curVal = sorted.val;
            int nextVal = sorted.next.val;
            if (curVal <= head.val && nextVal >= head.val) {
                head.next = sorted.next;
                sorted.next = head;
                break;
            }
            sorted = sorted.next;
        }
        helper(root, next);
    }
    
    public static void main(String[] args){
        InsertionSortList is = new InsertionSortList();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        n1.next = n2;
        
        is.insertionSortList(n1);
    }
}
