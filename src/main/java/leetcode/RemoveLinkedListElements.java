package leetcode;

public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {

        while (null != head && head.val == val) {
            head = head.next;
        }
        if (head == null) {
            return null;
        }

        ListNode pre = head;
        ListNode next = head.next;

        while (null != next) {
            if (next.val == val) {
                pre.next = next.next;
                next = pre.next;
            } else {
                pre = next;
                next = next.next;
            }
        }

        return head;
    }
}
