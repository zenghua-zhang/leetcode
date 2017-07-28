package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationSequence {
    public static void main(String[] args) {
        System.out.println(new PermutationSequence().getPermutation_2(4, 23));
    }
    
    public String getPermutation_2(int n, int k) {
        int[] num = new int[n];
        int permSum = 1;
        for (int i = 0; i < n; i++) {
            num[i] = i + 1;
            permSum *= (i + 1);
        }
        StringBuilder sb = new StringBuilder();
        k--;// change to base 0
        for (int i = 0; i < n; i++) {
            permSum = permSum / (n - i);
            int selected = k / permSum;
            sb.append(num[selected]);
            for (int j = selected; j < n - i - 1; j++)
                num[j] = num[j + 1];
            k = k % permSum;
        }
        return sb.toString();
    }

    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        for (int i = 1; i <= n; i++) {
            nums[i - 1] = i;
        }

        int i = 1;
        while (i < k) {
            nextPermutation(nums);
            i++;
        }
        StringBuilder sb = new StringBuilder();
        for (int j : nums) {
            sb.append(j);
        }

        return sb.toString();

    }

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
