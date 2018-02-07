package util

import model.ListNode

class ListNodeHelper {

    static ListNode genFromList(List list) {
        if (list.size() == 0) {
            return null
        }

        ListNode root = new ListNode(list[0])
        ListNode tmp = root;
        for (int i = 1; i < list.size(); i++) {
            ListNode node = new ListNode(list[i])
            tmp.next = node
            tmp = node
        }

        return root
    }

    static ListNode genFromString(String s) {
        List list = s.split(",").collect { it.trim() as Integer }
        genFromList(list)
    }

    static ListNode genFromInt(int[] ints) {
        genFromList(Arrays.asList(ints))
    }

    static void printListNode(ListNode node) {
        if (!node) {
            println 'null'
        }
        def list = []
        while (node != null) {
            list << node.val
            node = node.next
        }
        println list.join(", ")
    }

    static String toString(ListNode node, String joiner = ",") {
        def list = []
        while (node != null) {
            list << node.val
            node = node.next
        }
        list.join(joiner)
    }

    static void main(String[] args) {
        ListNode t = genFromInts([1, 2, 3, 64, 5] as int[])
        printListNode(t)
    }
}
