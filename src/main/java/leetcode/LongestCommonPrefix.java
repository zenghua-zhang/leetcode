package leetcode;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String min = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String str = strs[i];
            while (!str.startsWith(min)) {
                min = min.substring(0, min.length() - 1);
            }
        }
        return min;
    }
}
