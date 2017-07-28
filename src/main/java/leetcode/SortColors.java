package leetcode;

public class SortColors {
    public void sortColors(int[] nums) {
        int one = 0;
        int two = 0;
        for (int num : nums) {
            if (num == 1) {
                one++;
            } else if (num == 2) {
                two++;
            }
        }
        int zero = nums.length - one - two;

        for (int i = 0; i < zero; i++) {
            nums[i] = 0;
        }

        for (int i = zero; i < zero + one; i++) {
            nums[i] = 1;
        }

        for (int i = zero + one; i < nums.length; i++) {
            nums[i] = 2;
        }

    }

}
