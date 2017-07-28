package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        TreeSet<String> set = new TreeSet<String>();
        Set<String> countSet = new HashSet<String>();
        for (int i = 10; i <= s.length(); i++) {
            String tmp = s.substring(i - 10, i);
            if (countSet.contains(tmp)) {
                set.add(tmp);
            } else {
                countSet.add(tmp);
            }
        }

        return new ArrayList<String>(set);

    }

    public static void main(String[] strs) {
        String s = "012345678901234567890123456789";
        TreeSet<String> set = new TreeSet<String>();
        for (int i = 10; i <= s.length() - 10; i++) {
            String tmp = s.substring(i - 10, i);
            if (!set.contains(tmp) && s.substring(i).contains(tmp)) {
                set.add(tmp);
            }
        }
        List<String> list = new ArrayList<String>(set);
    }

}
