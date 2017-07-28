package leetcode;

public class ExcelSheetColumnNumber {

    public static void main(String[] args) {

        ExcelSheetColumnNumber d = new ExcelSheetColumnNumber();

        System.out.println(d.titleToNumber("B"));
    }

    public int titleToNumber(String s) {
        char[] cs = s.toCharArray();
        int result = 0;
        int tmp;
        for (char c : cs) {
            tmp = (c-64);
            result = result * 26 + tmp;
            
        }
        return result;

    }
}
