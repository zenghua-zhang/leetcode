package leetcode;

public class IntersectionTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        ListNode ret = null;
        while (a != null && b != null) {
            if (a == b) {
                ret = a;
                break;
            }
            if(a.next == null && b.next == null){
                return null;
            }
            a = a.next == null ? headB : a.next;
            b = b.next == null ? headA : b.next;
        }
        return ret;
    }

    public static void main(String[] args) {
        IntersectionTwoLinkedLists is = new IntersectionTwoLinkedLists();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        

        ListNode n3 = new ListNode(1);
        
        is.getIntersectionNode(n1, n3);

    }
}
