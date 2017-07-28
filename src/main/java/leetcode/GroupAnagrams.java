package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();

        for (String str : strs) {
            int[] ints = new int[26];
            for (char c : str.toCharArray()) {
                ints[c - 'a']++;
            }
            String key = Arrays.toString(ints);
            PriorityQueue<String> quere = map.get(key);
            if (null == quere) {
                quere = new PriorityQueue<String>();
            }
            quere.add(str);
            map.put(key, quere);
        }
        List<List<String>> result = new ArrayList<List<String>>();
        for (PriorityQueue<String> quere : map.values()) {
            List<String> strList = new ArrayList<String>();
            while (!quere.isEmpty()) {
                strList.add(quere.poll());
            }
            result.add(strList);
        }

        return result;
    }
}
