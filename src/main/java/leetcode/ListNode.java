package leetcode;

class ListNode {
    int val;

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}