package leetcode;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        if (digits.length == 0) {
            return digits;
        }
        for (int i = digits.length - 1; i >= 0; i--) {
            int n = digits[i];
            n++;
            if (n >= 10) {
                digits[i] = 0;
            } else {
                digits[i] = n;
                return digits;
            }
        }
        int[] ret = new int[digits.length + 1];
        ret[0] = 1;

        return ret;
    }

}
