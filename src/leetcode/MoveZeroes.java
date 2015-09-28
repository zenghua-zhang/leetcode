package leetcode;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        if (nums.length <= 1) {
            return;
        }

        int zero = 0;
        while (zero < nums.length) {
            if (nums[zero] == 0) {
                break;
            }
            zero++;
        }
        if (zero >= nums.length - 1) {
            return;
        }
        int n = zero + 1;

        while (n < nums.length) {
            if (nums[n] != 0) {
                swap(nums, zero, n);
                zero++;
            }
            n++;
        }

    }

    private void swap(int[] nums, int s, int e) {
        int tmp = nums[s];
        nums[s] = nums[e];
        nums[e] = tmp;
    }
}
