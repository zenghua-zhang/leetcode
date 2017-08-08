package leetcode;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Assert;
import org.junit.Test;

public class RepeatedSubstringPattern {

  public boolean repeatedSubstringPattern(String s) {
    return (s + s).indexOf(s, 1) < s.length();
  }

  @Test
  public void testCode() {
    RepeatedSubstringPattern rsp = new RepeatedSubstringPattern();
    assertThat(rsp.repeatedSubstringPattern("abab"), is(true));
    assertThat(rsp.repeatedSubstringPattern("aba"), is(false));
    assertThat(rsp.repeatedSubstringPattern("abcabcabcabc"), is(true));
  }

}
