package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ValidParentheses {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put(']', '[');
        map.put('}', '{');
        map.put(')', '(');

        LinkedList<Character> list = new LinkedList<Character>();

        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                list.add(c);
            } else {
                Character p = list.pollLast();
                if (p == null || p != map.get(c)) {
                    return false;
                }
            }
        }

        return list.isEmpty();
    }
}
