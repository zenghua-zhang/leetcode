package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LinkedListCycle {
    
    //�˴�����hashset�� ��ͨ�õķ�����������������slow �� fast���Ƿ������
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
