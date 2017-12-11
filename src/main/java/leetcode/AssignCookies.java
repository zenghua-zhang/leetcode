package leetcode;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import org.junit.Test;

public class AssignCookies {

  public int findContentChildren(int[] g, int[] s) {
    if (g.length == 0 || s.length == 0) {
      return 0;
    }
    Arrays.sort(g);
    Arrays.sort(s);

    int ret = 0;

    int gpos = g.length - 1, spos = s.length - 1;

    while (gpos >= 0 && spos >= 0) {
      if (s[spos] >= g[gpos]) {
        ret++;
        spos--;
      }
      gpos--;
    }

    return ret;
  }

  @Test
  public void test() {
    AssignCookies ac = new AssignCookies();
    assertThat(ac.findContentChildren(new int[]{1, 2}, new int[]{1, 2, 3}), is(2));
    assertThat(ac.findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1}), is(1));
  }
}
