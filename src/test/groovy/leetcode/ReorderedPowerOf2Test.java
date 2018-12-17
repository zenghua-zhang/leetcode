package leetcode;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class ReorderedPowerOf2Test {

  private ReorderedPowerOf2 test;

  @Before
  public void setUp() {
    test = new ReorderedPowerOf2();
  }

  @Test
  public void reorderedPowerOf2() {
    test.reorderedPowerOf2(46);
  }

  @Test
  public void getDigits() {
    assertThat(test.getDigits(64), is(2));
    assertThat(test.getDigits(3), is(1));
    assertThat(test.getDigits(223), is(3));
  }

  @Test
  public void intDigits() {
    assertEquals("0100000000", test.intDigits(1));
    assertEquals("0010000000", test.intDigits(2));
    assertEquals("1211000100", test.intDigits(131072));
    assertEquals("1100111110", test.intDigits(1048576));
    assertEquals("1111011111", test.intDigits(536870912));
  }


}