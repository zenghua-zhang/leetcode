package leetcode;

public class FriendsOfAppropriateAges {

  public int numFriendRequests(int[] ages) {
    int[] count = new int[121];

    for (int age : ages) {
      count[age]++;
    }

    int ret = 0;
    for (int ageA = 1; ageA < 121; ageA++) {
      if (count[ageA] == 0) {
        continue;
      }
      int countA = count[ageA];
      for (int ageB = 1; ageB < 121; ageB++) {
        if (friend(ageB, ageA)) {
          continue;
        }
        int countB = count[ageB];
        ret += countA * countB;
        if (ageA == ageB) {
          ret -= countB;
        }

      }
    }

    return ret;

  }

  private boolean friend(int ageA, int ageB) {
    if (ageB <= 0.5 * ageA + 7) {
      return true;
    }
    if (ageB > ageA) {
      return true;
    }
    if (ageB > 100 && ageA < 100) {
      return true;
    }
    return false;
  }

}
