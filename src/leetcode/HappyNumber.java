package leetcode;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> s = new HashSet<Integer>();
        while (true) {
            n = cal(n);
            if (n == 1) {
                return true;
            } else {
                if (s.contains(n)) {
                    return false;
                } else {
                    s.add(n);
                }
            }

        }
    }

    private int cal(int n) {
        int total = 0;
        while (n > 0) {
            int t = n % 10;
            total += t * t;
            n = n / 10;
        }
        return total;
    }
}
