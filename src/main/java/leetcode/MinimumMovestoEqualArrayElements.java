package leetcode;

public class MinimumMovestoEqualArrayElements {
    public int minMoves(int[] nums) {
        if (nums.length == 1 || nums.length == 1) {
            return 0;
        }
        int ret = 0;
        int min = Integer.MAX_VALUE;
        for (int i : nums) {
            min = Math.min(min, i);
        }

        for (int i : nums) {
            ret += i - min;
        }

        return ret;
    }
}
