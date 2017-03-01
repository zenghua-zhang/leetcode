package leetcode;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] ret = new int[nums.length];
        ret[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tmp = nums[i] + ret[i - 1];
            ret[i] = Math.max(tmp, nums[i]);
        }
        int res = Integer.MIN_VALUE;
        for (int i : ret) {
            res = Math.max(res, i);
        }

        return res;
    }
}
