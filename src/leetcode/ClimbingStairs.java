package leetcode;

public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] ret = new int[n];
        ret[0] = 1;
        ret[1] = 2;
        int i = 2;
        while (i < n) {
            ret[i] = ret[i - 1] + ret[i - 2];
            i++;
        }
        return ret[n - 1];
    }
}
