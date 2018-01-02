package leetcode;

import model.ListNode;

public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        int nm = n;
        int len = 0;
        while (true) {
            fast = fast.next;
            len++;
            if(fast == null){
                break;
            }
            if (n > 0) {
                n--;
            } else {
                slow = slow.next;
            }
        }
        if (len == nm) {
            if(len == 1){
                return null;   
            }else{
                return head.next;
            }
        }
        ListNode tmp = slow.next.next;

        slow.next = tmp;

        return head;
    }
}
