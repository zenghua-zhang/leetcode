package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReorderedPowerOf2 {

  public boolean reorderedPowerOf2(int N) {
    int digit_N = getDigits(N);

    List<String> l = power2(digit_N);

    return l.contains(intDigits(N));
  }

  int getDigits(int N) {
    int digits = 1;
    int tmp = N;
    while ((tmp /= 10) > 0) {
      digits++;
    }
    return digits;
  }

  List<String> power2(int targetDigit) {
    List<String> list = new ArrayList<>();
    int start = 0, end = 0;
    if (targetDigit == 1) {
      end = 3;
    } else if (targetDigit == 2) {
      start = 4;
      end = 6;
    } else if (targetDigit == 3) {
      start = 7;
      end = 9;
    } else if (targetDigit == 4) {
      start = 10;
      end = 13;
    } else if (targetDigit == 5) {
      start = 14;
      end = 16;
    } else if (targetDigit == 6) {
      start = 17;
      end = 19;
    } else if (targetDigit == 7) {
      start = 20;
      end = 23;
    } else if (targetDigit == 8) {
      start = 24;
      end = 26;
    } else if (targetDigit == 9) {
      start = 27;
      end = 29;
    } else if (targetDigit == 10) {
      start = 30;
      end = 30;
    } else {
      return Collections.emptyList();
    }

    for (int i = start; i <= end; i++) {
      list.add(intDigits(1 << i));
    }

    return list;
  }

  String intDigits(int i) {
    int[] digits = new int[10];
    while (i > 0) {
      int t = i % 10;
      digits[t]++;
      i /= 10;
    }
    StringBuilder sb = new StringBuilder();
    for (int digit : digits) {
      sb.append(digit);
    }
    return sb.toString();
  }


}
