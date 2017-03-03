package leetcode;

import java.util.Arrays;

public class MinimumMovestoEqualArrayElementsII {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int mid = nums[nums.length / 2];
        int ret = 0;
        for (int i : nums) {
            ret += Math.abs(i - mid);
        }
        return ret;
    }
}
