package leetcode;

public class SingleElementInASortedArray {

  public int singleNonDuplicate(int[] nums) {

    for (int i = 0; i < nums.length - 1; i = i + 2) {
      if (nums[i] != nums[i + 1]) {
        return nums[i];
      }
    }
    return nums[nums.length - 1];

  }

  public int singleNonDuplicate_2(int[] nums) {

    int ret = 0;

    for (int num : nums) {
      ret ^= num;
    }
    return ret;

  }


}
