package leetcode;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class BullsAndCows {

  public String getHint(String secret, String guess) {
    int A = 0, B = 0;
    char[] secretChars = secret.toCharArray();
    char[] guessChars = guess.toCharArray();
    int[] secretPos = new int[10];
    int[] guessPos = new int[10];

    for (int i = 0; i < secretChars.length; i++) {
      if (secretChars[i] == guessChars[i]) {
        A++;
      }
      secretPos[secretChars[i] - '0']++;
      guessPos[guessChars[i] - '0']++;
    }

    for (int i = 0; i < 10; i++) {
      B += Math.min(secretPos[i], guessPos[i]);
    }

    return A + "A" + (B - A) + "B";
  }

  @Test
  public void testGetHint() {
    BullsAndCows bac = new BullsAndCows();
    assertThat(bac.getHint("1123", "0111"), is("1A1B"));
    assertThat(bac.getHint("1807", "7810"), is("1A3B"));

  }
}
