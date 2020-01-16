package leetcode;

import java.util.LinkedList;

public class FractionAdditionAndSubtraction {

  public String fractionAddition(String expression) {

    LinkedList<Fraction> fractions = new LinkedList<>();
    StringBuilder sb = new StringBuilder();
    sb.append(expression.charAt(0));

    for (int i = 1; i < expression.length(); i++) {
      char c = expression.charAt(i);
      if (c == '+' || c == '-') {
        fractions.add(new Fraction(sb.toString()));
        sb = new StringBuilder();
      }
      sb.append(c);
    }
    fractions.add(new Fraction(sb.toString()));

    if (fractions.size() == 1) {
      return expression;
    }

    int commonMult = 1;
    for (Fraction f : fractions) {
      commonMult = minCommonMultiple(commonMult, f.denominator);
    }

    int numeratorSum = 0;
    for (Fraction f : fractions) {
      numeratorSum += f.numerator * (commonMult / f.denominator);
    }
    if (numeratorSum == 0) {
      return "0/1";
    }

    int commonDivisor = maxCommonDivisor(numeratorSum, commonMult);

    return (numeratorSum / commonDivisor) + "/" + (commonMult / commonDivisor);
  }

  private int minCommonMultiple(int m, int n) {
    return m * n / maxCommonDivisor(m, n);
  }


  private int maxCommonDivisor(int m, int n) {
    m = Math.abs(m);
    n = Math.abs(n);

    if (m < n) {
      int temp = m;
      m = n;
      n = temp;
    }
    while (m % n != 0) {
      int temp = m % n;
      m = n;
      n = temp;
    }
    return n;
  }

  private static class Fraction {

    @Override
    public String toString() {
      return "Fraction{" +
          "numerator=" + numerator +
          ", denominator=" + denominator +
          '}';
    }

    private int numerator;

    private int denominator;

    private Fraction(String expression) {
      String[] split = expression.split("/");

      numerator = Integer.valueOf(split[0]);
      denominator = Integer.valueOf(split[1]);

    }

  }


  public static void main(String[] args) {
    FractionAdditionAndSubtraction subtraction = new FractionAdditionAndSubtraction();
//    subtraction.fractionAddition("1/2-1/2-1/3");
//    subtraction.fractionAddition("1/2+2/42+1/3+1/7");
//    subtraction.fractionAddition("1/3-1/2");
    subtraction.fractionAddition("1/3-1/3");


  }
}
