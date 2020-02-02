package leetcode;

public class FirstMissingPositive {

  public int firstMissingPositive(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 1;
    }

    int N = nums.length;

    for (int i = 0; i < N; i++) {
      if (nums[i] > N || nums[i] <= 0) {
        nums[i] = -1;
      }
    }

    for (int i = 0; i < N; i++) {
      while (nums[i] != -1 && nums[i] != nums[nums[i]-1]) {
        swap(nums, i, nums[i] - 1);
      }
    }

    for (int i = 0; i < N; i++) {
      if (nums[i] != (i+1)) {
        return i + 1;
      }
    }

    return N;
  }

  private void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}
