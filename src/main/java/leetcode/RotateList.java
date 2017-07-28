package leetcode;

public class RotateList {
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        if (n == 0) {
            return head;
        }
        if (head.next == null) {
            return head;
        }
        int len = 1;
        ListNode tmp = head;
        while (true) {
            if (tmp.next == null) {
                tmp.next = head;
                break;
            } else {
                tmp = tmp.next;
            }
            len++;
        }
        int walk = len - n % len - 1;
        ListNode target = head;
        while (walk > 0) {
            target = target.next;
            walk -- ;
        }
        ListNode ret = target.next;
        target.next = null;

        return ret;

    }
}
