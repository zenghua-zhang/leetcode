package leetcode;

import model.ListNode;

public class RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode s = head;
        ListNode t = head.next;
        while (true) {
            if (t.val != s.val) {
                s.next = t;
                s = t;
            }

            if (t.next != null) {
                t = t.next;
            } else {
                if(t.val==s.val){
                    s.next = null;
                }
                break;
            }
        }

        return head;
    }
}
