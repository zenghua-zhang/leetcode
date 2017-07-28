package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        Comparator<Integer> com = new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                String s1 = String.valueOf(o1);
                String s2 = String.valueOf(o2);
                return (s2+s1).compareTo(s1+s2);
            }
        };
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<Integer>();
        for (int num : nums) {
            list.add(num);
        }
        Collections.sort(list, com);
        
        if(list.get(0) == 0){
            return "0";
        }
        for (Integer num : list) {
            sb.append(num);
        }
        
        return sb.toString();
    }

    public static void main(String[] args) {
        LargestNumber ln = new LargestNumber();
        int[] nums = new int[] { 0,0,0,0,1 };
        System.out.println(ln.largestNumber(nums));
    }
}
