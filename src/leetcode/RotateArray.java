package leetcode;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        if (k == 0) {
            return;
        }
        int l = nums.length;
        k = k % l;
        reverse(nums, 0, l - k - 1);
        reverse(nums, l - k, l - 1);
        reverse(nums, 0, l - 1);

    }

    private void reverse(int[] nums, int s, int e) {
        while (e > s) {
            swap(nums, s, e);

            e--;
            s++;
        }

    }

    private void swap(int[] nums, int s, int e) {
        int tmp = nums[s];
        nums[s] = nums[e];
        nums[e] = tmp;
    }
}
