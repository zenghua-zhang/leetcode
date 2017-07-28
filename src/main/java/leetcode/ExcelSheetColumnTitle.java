package leetcode;

public class ExcelSheetColumnTitle {

    public String convertToTitle(int n) {
        if (n <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();

        int m = 0;
        while (n > 0) {
            m = n % 26;
            if (m == 0) {
                m = 26;
            }
            sb.append((char) (m + 'A' - 1));
            n = n / 26;
            if (m == 26) {
                n--;
            }
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        ExcelSheetColumnTitle s = new ExcelSheetColumnTitle();
        System.out.println(s.convertToTitle(52));
    }

}
