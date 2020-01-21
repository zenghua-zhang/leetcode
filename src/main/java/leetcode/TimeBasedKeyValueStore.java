package leetcode;

import java.util.TreeMap;

public class TimeBasedKeyValueStore {

  class TimeMap {

    TreeMap<TimeKey, String> map;

    /**
     * Initialize your data structure here.
     */
    public TimeMap() {
      map = new TreeMap<>();

    }

    public void set(String key, String value, int timestamp) {

      map.put(new TimeKey(key, timestamp), value);

    }

    public String get(String key, int timestamp) {
      TimeKey timeKey = map.floorKey(new TimeKey(key, timestamp));
      if (timeKey == null) {
        return "";
      }
      return map.get(timeKey);
    }

    private class TimeKey implements Comparable<TimeKey> {

      private final String key;

      private final Integer timestamp;

      public TimeKey(String key, Integer timestamp) {
        this.key = key;
        this.timestamp = timestamp;
      }


      @Override
      public int compareTo(TimeKey that) {
        if (this.key.compareTo(that.key) < 0) {
          return -1;
        } else if (this.key.compareTo(that.key) > 0) {
          return 1;
        }

        if (this.timestamp.compareTo(that.timestamp) < 0) {
          return -1;
        } else if (this.timestamp.compareTo(that.timestamp) > 0) {
          return 1;
        }
        return 0;
      }
    }
  }


}
