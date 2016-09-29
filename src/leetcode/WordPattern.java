package leetcode;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        char[] chars = pattern.toCharArray();
        String[] words = str.split(" ");

        if (chars.length != words.length) {
            return false;
        }
        Map<Character, String> charToStr = new HashMap<>();
        Map<String, Character> strToChar = new HashMap<>();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            String s = words[i];

            if (charToStr.get(c) == null && strToChar.get(s) == null) {
                charToStr.put(c, s);
                strToChar.put(s, c);
            } else {
                if (!s.equals(charToStr.get(c)) || strToChar.get(s) != c) {
                    return false;
                }
            }

        }

        return true;
    }

    public static void main(String[] strs) {
        WordPattern w = new WordPattern();
        System.out.println(w.wordPattern("abba", "dog dog dog dog"));
    }
}
