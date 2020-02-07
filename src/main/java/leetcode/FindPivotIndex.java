package leetcode;

public class FindPivotIndex {

  public int pivotIndex(int[] nums) {
    if (nums == null) {
      return -1;
    }
    if (nums.length == 1) {
      return 0;
    }
    if (nums.length < 3) {
      return -1;
    }

    int rightSum = 0;
    for (int num : nums) {
      rightSum += num;
    }

    int leftSum = 0;

    for (int i = 0; i < nums.length - 1; i++) {
      leftSum += nums[i];
      if (leftSum == rightSum) {
        return i;
      }
      rightSum -= nums[i];
    }

    return -1;
  }


}
