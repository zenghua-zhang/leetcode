package leetcode;

public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        if (version1.equals(version2)) {
            return 0;
        }

        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int l1 = v1.length;
        int l2 = v2.length;
        int i = 0;
        while (i < Math.max(l1, l2)) {
            int n1 = 0, n2 = 0;
            if (i < l1) {
                n1 = Integer.valueOf(v1[i]);
            }
            if (i < l2) {
                n2 = Integer.valueOf(v2[i]);
            }

            if (n1 > n2) {
                return 1;
            } else if (n1 < n2) {
                return -1;
            }
            i++;
        }
        return 0;
    }

    public static void main(String[] args) {
        CompareVersionNumbers c = new CompareVersionNumbers();
        System.out.println(c.compareVersion("1.0", "1"));
    }
}
