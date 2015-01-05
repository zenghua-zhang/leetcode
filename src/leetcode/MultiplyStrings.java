package leetcode;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

public class MultiplyStrings extends TestCase {
    public static void main(String[] strs) {
        MultiplyStrings ms = new MultiplyStrings();
        System.out.println(ms.multiply("10", "100"));
    }

    public void testAddStr() {
        assertEquals(addStr("1000", "1000"), "2000");
        assertEquals(addStr("9999", "10"), "10009");
    }

    public void testMult() {
        assertEquals(multiply_2("5", "12"), "60");
        assertEquals(multiply_2("100", "10"), "1000");
    }

    public String multiply_2(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int tmp;
        int[] strs = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                tmp = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                strs[len1 - i + len2 - j - 2] += tmp;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            int digit = strs[i] % 10;
            int carry = strs[i] / 10;
            if (i + 1 < strs.length) {
                strs[i + 1] += carry;
            }
            sb.append(digit);
        }
        sb = sb.reverse();

        while (sb.charAt(0) == '0' && sb.length() > 1) {
            sb.deleteCharAt(0);
        }
        return sb.toString();

    }

    // --------------------------------------//

    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        String[] strs = new String[len1 * len2];
        int k = 0;
        int tmp;
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                tmp = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                strs[k] = addZeroToEnd(tmp, len1 - i + len2 - j - 2);
                System.out.println(k + " " + i + " " + j);
                k++;
            }
        }
        String result = "0";
        for (String s : strs) {
            if (null != s) {
                result = addStr(result, s);
            }

        }

        return result;
    }

    private String addZeroToEnd(int input, int len) {
        StringBuilder sb = new StringBuilder();
        sb.append(input);
        while (len > 0) {
            sb.append("0");
            len--;
        }

        return sb.toString();
    }

    private String addStr(String a, String b) {
        int lengthDiff = a.length() - b.length();
        if (lengthDiff < 0) {
            a = addZero(-lengthDiff, a);
        } else {
            b = addZero(lengthDiff, b);
        }
        boolean carrybit = false;
        int tmp;
        StringBuilder sb = new StringBuilder();
        for (int i = a.length() - 1; i >= 0; i--) {
            tmp = (a.charAt(i) - '0') + (b.charAt(i) - '0')
                    + (carrybit ? 1 : 0);
            carrybit = tmp > 9;
            sb.append(tmp % 10);
        }

        if (carrybit) {
            sb.append("1");
        }

        return sb.reverse().toString();
    }

    private String addZero(int length, String input) {
        StringBuilder r = new StringBuilder();
        while (length > 0) {
            r.append("0");
            length--;
        }
        r.append(input);
        return r.toString();
    }

}
