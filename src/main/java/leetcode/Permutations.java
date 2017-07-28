package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> resList = new ArrayList<List<Integer>>();
        permu(resList, num, 0);

        return resList;
    }

    private void permu(List<List<Integer>> resList, int[] num, int s) {
        if (s == num.length) {
            List<Integer> l = new ArrayList<Integer>();
            for (int a : num) {
                l.add(a);
            }
            resList.add(l);
        }

        for (int c = s; c < num.length; c++) {
            swap(c, s, num);
            permu(resList, num, s + 1);
            swap(c, s, num);
        }

    }

    private void swap(int a, int b, int[] num) {
        int tmp = num[a];
        num[a] = num[b];
        num[b] = tmp;

    }

}
