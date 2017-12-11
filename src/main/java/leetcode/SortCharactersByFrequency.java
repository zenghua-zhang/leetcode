package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import org.junit.Test;

public class SortCharactersByFrequency {

  public String frequencySort(String s) {
    Map<Character, Integer> map = new HashMap<>();
    for (char c : s.toCharArray()) {
      int v = map.getOrDefault(c, 0);
      map.put(c, v + 1);
    }

    TreeMap<Integer, List<Character>> treeMap = new TreeMap<>(Comparator.reverseOrder());
    for (Entry<Character, Integer> entry : map.entrySet()) {
      List<Character> chars = treeMap.getOrDefault(entry.getValue(), new ArrayList<>());
      chars.add(entry.getKey());
      treeMap.put(entry.getValue(), chars);
    }

    StringBuilder sb = new StringBuilder();

    for (Entry<Integer, List<Character>> entry : treeMap.entrySet()) {
      for (Character c : entry.getValue()) {
        sb.append(nCopies(entry.getKey(), c));
      }
    }

    return sb.toString();
  }

  private char[] nCopies(int times, Character character) {
    char[] chars = new char[times];
    Arrays.fill(chars, character);
    return chars;
  }

  @Test
  public void test() {
    SortCharactersByFrequency scbf = new SortCharactersByFrequency();
    System.out.println(scbf.frequencySort("tree"));
  }


}
