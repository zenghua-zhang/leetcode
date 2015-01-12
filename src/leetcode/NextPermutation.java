package leetcode;

import java.util.Arrays;
import java.util.Collections;

import junit.framework.TestCase;

public class NextPermutation extends TestCase {
    public void nextPermutation(int[] num) {
        if (num.length < 2) {
            return;
        }
        int i = num.length - 2, j = num.length - 1;
        while (i >= 0) {
            if (num[i] < num[i + 1]) {
                break;
            }
            i--;
        }
        if (i < 0) {
            reverse(0, num);
            return;
        }
        while (!(num[j] > num[i])) {
            j--;
        }
        swap(i, j, num);
        reverse(i + 1, num);

    }

    private void reverse(int s, int[] num) {
        int l = num.length - 1;
        while (s < l) {
            swap(s, l, num);
            s++;
            l--;
        }
    }

    private void swap(int a, int b, int[] num) {
        int tmp = num[a];
        num[a] = num[b];
        num[b] = tmp;

    }
}
