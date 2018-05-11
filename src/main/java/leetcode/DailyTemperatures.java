package leetcode;

public class DailyTemperatures {

  public int[] dailyTemperatures(int[] temperatures) {
    int length = temperatures.length;
    int[] result = new int[length];
    int[] temps = new int[101];

    temps[temperatures[length - 1]] = length - 1;

    for (int i = length - 2; i >= 0; i--) {
      int temp = temperatures[i];
      int ret = Integer.MAX_VALUE;
      for (int j = temp + 1; j <= 100; j++) {
        if (temps[j] != 0) {
          ret = Math.min(temps[j] - i, ret);
        }
      }

      ret = ret == Integer.MAX_VALUE ? 0 : ret;

      result[i] = ret;

      temps[temperatures[i]] = i;
    }

    return result;
  }
}
