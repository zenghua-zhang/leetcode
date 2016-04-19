package leetcode;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> map = new HashMap<Character, Character>();

        for (int i = 0; i < s.length(); i++) {
            Character schar = s.charAt(i);
            Character tchar = t.charAt(i);
            if (map.get(schar) == null) {
                map.put(schar, tchar);
            } else if (map.get(schar) != tchar) {
                return false;
            }
        }
        map.clear();

        for (int i = 0; i < s.length(); i++) {
            Character schar = s.charAt(i);
            Character tchar = t.charAt(i);
            if (map.get(tchar) == null) {
                map.put(tchar, schar);
            } else if (map.get(tchar) != schar) {
                return false;
            }
        }

        return true;
    }
}
