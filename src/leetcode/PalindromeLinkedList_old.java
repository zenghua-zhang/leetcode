package leetcode;

public class PalindromeLinkedList_old {
    public boolean isPalindrome(ListNode head) {
        ListNode cloned = clone(head);
        ListNode tmp = reverse(null, head);

        return isSame(cloned, tmp);
    }

    private ListNode reverse(ListNode pre, ListNode next) {
        if (next == null) {
            return pre;
        }
        ListNode tmp = next.next;
        next.next = pre;

        return reverse(next, tmp);
    }

    private ListNode clone(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode tmp = new ListNode(head.val);
        tmp.next = clone(head.next);

        return tmp;
    }

    private boolean isSame(ListNode r1, ListNode r2) {
        if (null == r1 && null == r2) {
            return true;
        }
        if (r1.val != r2.val) {
            return false;
        }

        return isSame(r1.next, r2.next);
    }

}
