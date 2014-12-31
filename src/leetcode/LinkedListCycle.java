package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LinkedListCycle {
    
    //此处用了hashset， 更通用的方法是用两个参数，slow 和 fast看是否会相遇
    public boolean hasCycle(ListNode head) {
        ListNode n = head;
        HashSet<ListNode> set = new HashSet<ListNode>();
        while(null != n){
            if(set.contains(n)){
                return true;
            }else{
                set.add(n);
                n = n.next;
            }
        }

        return false;
    }
}
