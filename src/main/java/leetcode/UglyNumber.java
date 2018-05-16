package leetcode;

public class UglyNumber {

  public boolean isUgly(int num) {
    if (num <= 1) {
      return false;
    }
    num = helper(num, 5);
    num = helper(num, 3);
    num = helper(num, 2);

    return num == 1;
  }

  private Integer helper(int num, int factor) {
    while (num % factor == 0) {
      num = num / factor;
    }
    return num;
  }


}
