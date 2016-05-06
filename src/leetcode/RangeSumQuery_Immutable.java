package leetcode;

public class RangeSumQuery_Immutable {
    public class NumArray {

        private int[] sums;

        public NumArray(int[] nums) {
            sums = new int[nums.length];
            if (nums.length == 0) {
                return;
            }
            sums[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                sums[i] = sums[i - 1] + nums[i];
            }
        }

        public int sumRange(int i, int j) {
            return i == 0 ? sums[j] : sums[j] - sums[i - 1];
        }
    }
}
