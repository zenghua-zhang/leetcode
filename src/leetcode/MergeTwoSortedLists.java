package leetcode;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (null == l1 && null == l2) {
            return null;
        }
        ListNode node = null;
        int v1 = l1 == null ? Integer.MAX_VALUE : l1.val;
        int v2 = l2 == null ? Integer.MAX_VALUE : l2.val;
        ListNode next1, next2;

        if (v1 < v2) {
            node = l1;
            next1 = l1.next;
            next2 = l2;
        } else {
            node = l2;
            next1 = l1;
            next2 = l2.next;
        }
        node.next = mergeTwoLists(next1, next2);
        return node;
    }

}
