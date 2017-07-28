package leetcode;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode mid = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            mid = mid.next;
            fast = fast.next.next;
        }
        mid.next = reverse(null, mid.next);

        return isSame(head, mid.next);

    }

    private ListNode reverse(ListNode pre, ListNode next) {
        if (next == null) {
            return pre;
        }
        ListNode tmp = next.next;
        next.next = pre;

        return reverse(next, tmp);
    }

    private boolean isSame(ListNode head, ListNode mid) {
        if (null == mid) {
            return true;
        }
        if (head.val != mid.val) {
            return false;
        }

        return isSame(head.next, mid.next);
    }
}
