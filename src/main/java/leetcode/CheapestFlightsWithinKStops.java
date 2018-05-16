package leetcode;

import java.util.ArrayList;
import java.util.List;

public class CheapestFlightsWithinKStops {

  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
    City[] cities = new City[n];
    for (int i = 0; i < n; i++) {
      cities[i] = new City(i);
    }

    for (int[] flight : flights) {
      City srcCity = cities[flight[0]];
      City destCity = cities[flight[1]];
      int price = flight[2];

      srcCity.flyTo(price, destCity);
    }

    return cities[src].getCheapest(cities[dst], K + 1);
  }

  private class City {

    private int number;

    private List<Flight> flightList;

    private boolean checked;

    private Integer cheapest;

    public City(int number) {
      this.number = number;
      flightList = new ArrayList<>();
    }

    public void flyTo(int price, City dest) {
      Flight flight = new Flight(price, dest);

      flightList.add(flight);
    }

    public Integer getCheapest(City dest, int stop) {
      if (stop < 0) {
        return -1;
      }
      if (dest == this) {
        return 0;
      }

      if (flightList.size() == 0) {
        return -1;
      }

      int min = Integer.MAX_VALUE;
      checked = true;
      for (Flight flight : flightList) {
        if (flight.dest.checked) {
          continue;
        }
        int v = flight.dest.getCheapest(dest, stop - 1);
        if (v != -1) {
          min = Math.min(min, v + flight.price);
        }
      }
      checked = false;

      cheapest = min != Integer.MAX_VALUE ? min : -1;
      return cheapest;
    }
  }

  private class Flight {

    private int price;

    private City dest;

    public Flight(int price, City dest) {
      this.price = price;
      this.dest = dest;
    }
  }
}
