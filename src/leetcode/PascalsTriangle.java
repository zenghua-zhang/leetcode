package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        if (numRows == 0) {
            return resultList;
        }
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<Integer>();
            if (i == 0) {
                list.add(1);
            } else {
                List<Integer> preList = resultList.get(i-1);
                for (int j = 0; j <= i; j++) {
                    if (j == 0 || j == i) {
                        list.add(1);
                    } else {
                        int t = preList.get(j-1)+preList.get(j);
                        list.add(t);
                    }
                }
            }
            resultList.add(list);
        }

        return resultList;
    }
}
