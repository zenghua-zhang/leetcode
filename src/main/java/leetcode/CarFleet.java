package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarFleet {

  public int carFleet(int target, int[] position, int[] speed) {
    if (speed.length == 0 || speed.length != position.length) {
      return 0;
    }
    List<Car> queue = new ArrayList<>();
    for (int i = 0; i < position.length; i++) {
      queue.add(new Car(position[i], speed[i], target));
    }

    Collections.sort(queue);

    int result = 1;
    int n = 0;
    Car ahead = queue.get(0);

    while (n++ < position.length - 1) {
      Car tmp = queue.get(n);

      if (ahead.targetTime < tmp.targetTime) {
        result++;
        ahead = tmp;
      }
    }

    return result;
  }

  private static class Car implements Comparable<Car> {

    private int position;

    private double targetTime;

    private Car(int position, int speed, int target) {
      this.position = position;

      this.targetTime = ((double) (target - position)) / speed;
    }

    @Override
    public int compareTo(Car that) {
      if (this.position > that.position) {
        return -1;
      } else if (this.position < that.position) {
        return 1;
      }
      return 0;
    }
  }

}
