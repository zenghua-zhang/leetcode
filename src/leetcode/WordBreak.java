package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {

    public static void main(String[] args) {
        String s = "banana";
        Set<String> dict = new HashSet<String>();
        dict.add("ana");
        dict.add("b");
        dict.add("ban");
//        dict.add("banana");
        dict.add("a");
        WordBreak solution = new WordBreak();
        System.out.println(solution.wordBreak(s, dict));
    }

    public boolean wordBreak(String s, Set<String> dict) {
        int len = s.length();
        boolean[] arrays = new boolean[len + 1];
        arrays[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (arrays[j] && dict.contains(s.substring(j, i))) {
                    // f(n) = f(0,i) + f(i,j) + f(j,n)
                    arrays[i] = true;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(arrays));
        return arrays[len];
    }
}
