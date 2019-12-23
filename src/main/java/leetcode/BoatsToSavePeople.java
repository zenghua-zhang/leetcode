package leetcode;

import java.util.Arrays;

public class BoatsToSavePeople {

  public int numRescueBoats(int[] people, int limit) {
    if (people.length == 0) {
      return 0;
    }

    if (people.length == 1) {
      return 1;
    }

    Arrays.sort(people);

    int boat = 0;

    int start = 0, end = people.length - 1;
    while (start <= end) {
      int startWeight = people[start];
      int endWeight = people[end];

      boat++;
      end--;
      if (endWeight + startWeight <= limit) {
        start++;
      }
    }

    return boat;
  }
}
