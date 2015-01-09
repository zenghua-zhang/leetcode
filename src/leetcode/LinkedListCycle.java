package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LinkedListCycle {
    public boolean hasCycle_2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            if (fast.next == null) {
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    // 此处用了hashset， 更通用的方法是用两个参数，slow 和 fast看是否会相遇
    public boolean hasCycle(ListNode head) {
        ListNode n = head;
        HashSet<ListNode> set = new HashSet<ListNode>();
        while (null != n) {
            if (set.contains(n)) {
                return true;
            } else {
                set.add(n);
                n = n.next;
            }
        }

        return false;
    }
}
