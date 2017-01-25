package leetcode;

public class ReverseString {
    public String reverseString(String s) {
        char[] chars = s.toCharArray();
        int st = 0, e = chars.length - 1;
        while (st < e) {
            char tmp = chars[e];
            chars[e] = chars[st];
            chars[st] = tmp;

            st++;
            e--;
        }

        return new String(chars);
    }
}
