package leetcode;

public class HouseRobber {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] ret = new int[nums.length];
        ret[0] = nums[0];
        ret[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            ret[i] = Math.max(nums[i] + ret[i - 2], ret[i - 1]);
        }

        return ret[ret.length-1];
    }
}
