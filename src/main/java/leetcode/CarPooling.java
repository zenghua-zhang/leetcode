package leetcode;

public class CarPooling {

  public boolean carPooling(int[][] trips, int capacity) {
    int[] locations = new int[1001];

    for (int[] trip : trips) {
      int passengers = trip[0];
      int start = trip[1];
      int end = trip[2];

      for (int i = start; i <= end; i++) {
        locations[i] += passengers;
        if (locations[i] > capacity) {
          return false;
        }
      }
    }

    return true;
  }
}
