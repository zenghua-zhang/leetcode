package leetcode;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.LinkedList;
import org.junit.Test;

public class SolveTheEquation {

  public String solveEquation(String equation) {
    char[] chars = equation.toCharArray();
    int[] sums = new int[2];
    LinkedList<Character> queue = new LinkedList<>();
    boolean negation = false;

    for (int i = chars.length - 1; i >= 0; i--) {
      char c = chars[i];
      if (c == '-' || c == '+') {
        parseInt(queue, sums, c, negation);
      } else if (c == '=') {
        parseInt(queue, sums, c, negation);
        negation = true;
      } else {
        queue.add(c);
      }
    }
    parseInt(queue, sums, '+', negation);

    int xNum = sums[0];
    int num = sums[1];

    if (xNum == 0) {
      if (num == 0) {
        return "Infinite solutions";
      } else {
        return "No solution";
      }
    }

    if (num == 0) {
      return "x=0";
    }
    return "x=" + (-num / xNum);
  }

  private void parseInt(LinkedList<Character> chars, int[] sums, char opt, boolean negation) {
    if (chars.isEmpty()) {
      return;
    }
    String str = stackToString(chars);
    int num = 0;
    if (str.endsWith("x")) {
      if (str.length() == 1) {
        num = 1;
      } else {
        num = Integer.valueOf(str.substring(0, str.length() - 1));
      }

    } else {
      num = Integer.valueOf(str);
    }
    boolean minus = opt == '-';
    if (negation ^ minus) {
      num *= -1;
    }

    if (str.endsWith("x")) {
      sums[0] += num;
    } else {
      sums[1] += num;
    }
  }

  private String stackToString(LinkedList<Character> chars) {
    StringBuilder sb = new StringBuilder();
    while (!chars.isEmpty()) {
      char b = chars.pollLast();
      sb.append(b);
    }
    return sb.toString();
  }

  @Test
  public void test() {
    SolveTheEquation ste = new SolveTheEquation();

    assertThat(ste.solveEquation("x+5-3+x=6+x-2"), is("x=2"));
    assertThat(ste.solveEquation("x=x"), is("Infinite solutions"));
    assertThat(ste.solveEquation("2x=x"), is("x=0"));
    assertThat(ste.solveEquation("2x+3x-6x=x+2"), is("x=-1"));
    assertThat(ste.solveEquation("x=x+2"), is("No solution"));
  }
}
