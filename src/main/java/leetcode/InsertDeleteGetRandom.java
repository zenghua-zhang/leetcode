package leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class InsertDeleteGetRandom {

  class RandomizedSet {

    Set<Integer> sets;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
      sets = new HashSet<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
      return sets.add(val);

    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
      return sets.remove(val);
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
      int size = sets.size();
      for (Integer i : sets) {
        if (0 == ThreadLocalRandom.current().nextInt(size--)) {
          return i;
        }
      }
      return 0;

    }
  }
}
