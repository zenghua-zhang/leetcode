package leetcode;

public class ProductOfArrayExceptSelf {

  public int[] productExceptSelf(int[] nums) {
    int length = nums.length;
    if (length <= 1) {
      return new int[]{1};
    }
    int[] ret = new int[length];
    int[] head = new int[length];
    int[] tail = new int[length];

    int tmp = 1;
    for (int i = 0; i < length; i++) {
      head[i] = tmp = tmp * nums[i];
    }
    tmp = 1;
    for (int i = length - 1; i >= 0; i--) {
      tail[i] = tmp = tmp * nums[i];
    }

    ret[0] = tail[1];
    ret[length - 1] = head[length - 2];

    for (int i = 1; i < length - 1; i++) {
      ret[i] = head[i - 1] * tail[i + 1];
    }

    return ret;

  }
}
