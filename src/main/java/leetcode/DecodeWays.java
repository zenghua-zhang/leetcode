package leetcode;

public class DecodeWays {
    public int numDecodings(String s) {
        if (null == s || "".equals(s) || s.charAt(0) == '0') {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int n = s.length();
        int[] res = new int[n + 1];
        res[n] = 1;
        res[n - 1] = s.charAt(n - 1) != '0' ? 1 : 0;
        for (int i = n - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                continue;
            }
            int v = Integer.valueOf(String.valueOf(s.charAt(i) + String.valueOf(s.charAt(i + 1))));
            res[i] = v <= 26 ? res[i + 1] + res[i + 2] : res[i + 1];
        }

        return res[0];
    }
}
