package leetcode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (null == l1 || null == l2) {
            return null;
        }
        return addTwo(l1, l2, false);
    }

    private ListNode addTwo(ListNode l1, ListNode l2, boolean carrybit) {
        if (null == l1 && null == l2) {
            if (carrybit) {
                return new ListNode(1);
            } else {
                return null;
            }
        }
        ListNode node = null;
        int a = l1 == null ? 0 : l1.val;
        int b = l2 == null ? 0 : l2.val;
        int c = a + b + (carrybit ? 1 : 0);
        carrybit = c >= 10;
        node = new ListNode(c % 10);
        ListNode next1 = l1 == null ? null : l1.next;
        ListNode next2 = l2 == null ? null : l2.next;

        node.next = addTwo(next1, next2, carrybit);

        return node;
    }
}
