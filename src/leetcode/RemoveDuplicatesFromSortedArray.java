package leetcode;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        if (A.length == 1) {
            return 1;
        }
        int ret = 0;
        int e = 1;
        while (e < A.length) {
            if (A[e] > A[ret]) {
                ret++;
                A[ret] = A[e];
            }
            e++;
        }

        A = Arrays.copyOf(A, ret+1);
        return ret+1;
    }
}
