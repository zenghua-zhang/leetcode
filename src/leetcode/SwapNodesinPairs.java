package leetcode;

public class SwapNodesinPairs {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);

        SwapNodesinPairs sn = new SwapNodesinPairs();
        head = sn.swapPairs(head);
        sn.println(head);
    }

    private void println(ListNode head) {
        ListNode node = head;
        while (null != node) {
            System.out.println(node.val);
            node = node.getNext();
        }
    }

    public ListNode swapPairs(ListNode head) {
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        ListNode tmp = head.next.next;
        ListNode next= head.next;
        next.next = head;
        head.next = swapPairs(tmp);

        return next;
    }
}
