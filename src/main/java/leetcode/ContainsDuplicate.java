package leetcode;

import java.util.BitSet;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        BitSet bs = new BitSet();
        BitSet nebs = new BitSet();

        for (int num : nums) {
            if (num < 0) {
                if (nebs.get(-num)) {
                    return true;
                } else {
                    nebs.set(-num);
                }

            } else {
                if (bs.get(num)) {
                    return true;
                } else {
                    bs.set(num);
                }
            }
        }

        return false;
    }
}
