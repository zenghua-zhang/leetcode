package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] num) {
        if (num.length < 3) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Arrays.sort(num);
        int length = num.length;
        for (int i = 0; i < length - 2; i++) {
            if (i != 0 && num[i - 1] == num[i]) {
                continue;
            }
            int j = i + 1;
            int k = length - 1;

            while (k > j) {
                int sum = num[i] + num[j] + num[k];
                if (sum == 0) {
                    List<Integer> l = new ArrayList<Integer>();
                    l.add(num[i]);
                    l.add(num[j]);
                    l.add(num[k]);
                    list.add(l);
                    j++;
                    k--;
                    while (j < k && num[j] == num[j - 1]) {
                        j++;
                    }
                    while (j < k && num[k] == num[k + 1]) {
                        k--;
                    }
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }

        return list;

    }
}
