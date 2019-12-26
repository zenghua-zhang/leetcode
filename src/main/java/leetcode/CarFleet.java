package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CarFleet {

  public int carFleet(int target, int[] position, int[] speed) {
    if (speed.length == 0 || speed.length != position.length) {
      return 0;
    }
    List<Car> cars = new ArrayList<>();
    for (int i = 0; i < position.length; i++) {
      cars.add(new Car(position[i], speed[i]));
    }

    Collections.sort(cars);
    LinkedList<Car> queue = new LinkedList<>(cars);

    int result = 1;
    Car ahead = queue.pop();
    while (!queue.isEmpty()) {
      Car tmp = queue.pop();

      if (((double) target - ahead.position) / ahead.speed < ((double) target - tmp.position) / tmp.speed) {
        result++;
        ahead = tmp;
      }
    }

    return result;
  }

  private static class Car implements Comparable<Car> {

    private int position;

    private int speed;

    private Car(int position, int speed) {
      this.position = position;
      this.speed = speed;
    }

    @Override
    public int compareTo(Car that) {
      if (this.position > that.position) {
        return -1;
      } else if (this.position < that.position) {
        return 1;
      }

      if (this.speed < that.speed) {
        return -1;
      } else if (this.speed > that.speed) {
        return 1;
      }
      return 0;
    }
  }

  public static void main(String[] args) {
    CarFleet cf = new CarFleet();
    System.out.println(cf.carFleet(12, new int[]{10, 8, 0, 5, 3, 10}, new int[]{2, 4, 1, 1, 3, 3}));
  }
}
