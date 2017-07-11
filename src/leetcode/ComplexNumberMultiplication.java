package leetcode;

public class ComplexNumberMultiplication {
    public String complexNumberMultiply(String a, String b) {
        int[] aints = parseStr(a);
        int[] bints = parseStr(b);

        int _a = aints[0];
        int _b = aints[1];
        int _x = bints[0];
        int _y = bints[1];

        return "" + (_a * _x - _b * _y) + "+" + (_a * _y + _b * _x) + "i";
    }

    private int[] parseStr(String a) {
        String[] strs = a.split("\\+");
        int x = Integer.valueOf(strs[0]);
        int y = Integer.valueOf(strs[1].substring(0, strs[1].length() - 1));

        return new int[] { x, y };

    }
    
}
