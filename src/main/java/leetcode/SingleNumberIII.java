package leetcode;

public class SingleNumberIII {

  public int[] singleNumber(int[] nums) {
    int a = 0;
    for (int i : nums) {
      a = a ^ i;
    }
    int bit = 0;
    for (int i = 0; i < 32; i++) {
      if (((a >> i) & 1) == 1) {
        bit = i;
        break;
      }
    }
    int r1 = 0, r2 = 0;
    for (int i : nums) {
      if (((i >> bit) & 1) == 1) {
        r1 = r1 ^ i;
      } else {
        r2 = r2 ^ i;
      }

    }

    return new int[]{r1, r2};

  }

}
