package leetcode;

public class CountingBits {
    public int[] countBits(int num) {
        int[] ret = new int[num + 1];
        if (num <= 0) {
            return ret;
        }
        ret[1] = 1;
        int tmp = 0;
        for (int i = 2; i <= num; i++) {
            if ((i & (i - 1)) == 0) {
                ret[i] = 1;
                tmp = i;
            } else {
                ret[i] = ret[tmp] + ret[i - tmp];
            }
        }

        return ret;
    }
}
