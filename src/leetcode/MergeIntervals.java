package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args){
        MergeIntervals m = new MergeIntervals();
        List<Interval> list = new ArrayList<Interval>();
        Interval i = new Interval(1,3);
        list.add(i);
        
        List<Interval> r = m.merge(list);
        System.out.println(r.get(0).start);
        
    }
    
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.isEmpty() || null == intervals){
            return  new ArrayList<Interval>(); 
        }
        Comparator<Interval> com = new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        };

        Collections.sort(intervals, com);
        
        List<Interval> list = new ArrayList<Interval>();
        Interval tmp = intervals.get(0);
        for(int i = 1;i<intervals.size();i++){
            Interval t = intervals.get(i);
            if(tmp.end < t.start){
                list.add(tmp);
                tmp = t;
            }else{
                tmp.end = Math.max(tmp.end, t.end);
            }
        }
        list.add(tmp);
        
        return list;
    }

}
