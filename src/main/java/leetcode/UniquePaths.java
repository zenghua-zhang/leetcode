package leetcode;

public class UniquePaths {
    // ��̬�滮�����ᣬ�����ϳ��ģ������������������p(n,m)=n(n-1)(n-2)����(n-m+1)= n!/(n-m)!
    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0)
            return 0;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                res[j] += res[j - 1];
            }
        }
        return res[n - 1];
    }
}
