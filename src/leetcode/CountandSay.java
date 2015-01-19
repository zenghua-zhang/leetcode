package leetcode;

public class CountandSay {
    public String countAndSay(int n) {
        if (n == 0) {
            return "";
        }
        int count = 1;
        String a = "1";
        StringBuilder sb = new StringBuilder();
        while (count < n) {
            int i = 1;
            int c = 1;
            sb.setLength(0);
            for (; i < a.length(); i++) {
                if (a.charAt(i) == a.charAt(i - 1)) {
                    c++;
                } else {
                    sb.append(c).append(a.charAt(i - 1) - '0');
                    c = 1;
                }

            }
            sb.append(c).append(a.charAt(i - 1) - '0');

            a = sb.toString();

            count++;
        }

        return a;
    }

}
