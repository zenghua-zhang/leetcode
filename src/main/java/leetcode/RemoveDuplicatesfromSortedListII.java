package leetcode;

public class RemoveDuplicatesfromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        head = deleteDuplate(head);
        ListNode next = head;
        while (next != null) {
            ListNode tmp = deleteDuplate(next.next);
            next.next = tmp;
            next = tmp;
        }

        return head;
    }

    private ListNode deleteDuplate(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        if (head.val == head.next.val) {
            while (true) {
                if (head.next == null || head.val != head.next.val) {
                    head = head.next;
                    break;
                }
                head = head.next;
            }
            if (null != head) {
                head = deleteDuplate(head);
            }
        }

        return head;
    }
}
