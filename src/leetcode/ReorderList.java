package leetcode;

import java.util.LinkedList;

public class ReorderList {

    public void reorderList(ListNode head) {
        if(null == head){
            return;
        }
        LinkedList<ListNode> ll = new LinkedList<ListNode>();
        ListNode node = head;
        ListNode next = null;
        while (node != null) {
            next = node.next;
            node.next = null;
            ll.add(node);
            node = next;
        }

        ListNode result =  ll.poll();
        ListNode nextNode = ll.pollLast();
        result.next = nextNode;
        boolean trigger = true;
        while(nextNode!=null){
            if(trigger){
                nextNode.next = ll.poll();
            }else{
                nextNode.next = ll.pollLast();
            }
            nextNode = nextNode.next;

            trigger = !trigger;
        }
        
        head = result;

    }

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
        
        ReorderList rl = new ReorderList();
//        rl.println(head);
        rl.reorderList(head);

    }

    private void println(ListNode head) {
        ListNode node = head;
        while (null != node) {
            System.out.println(node.val);
            node = node.getNext();
        }
    }
}
