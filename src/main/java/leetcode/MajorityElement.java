package leetcode;

public class MajorityElement {

  public int majorityElement(int[] nums) {
    int ret = nums[0], num = 1;
    for (int n = 1; n < nums.length; n++) {
      int tmp = nums[n];
      if (num == 0) {
        ret = nums[n];
        num++;
      } else if (ret == tmp) {
        num++;
      } else {
        num--;
      }
    }

    return ret;
  }
}
