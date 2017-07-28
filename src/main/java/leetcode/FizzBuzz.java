package leetcode;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> resList = new ArrayList<String>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                resList.add("FizzBuzz");
            } else if (i % 3 == 0) {
                resList.add("Fizz");
            } else if (i % 5 == 0) {
                resList.add("Buzz");
            } else {
                resList.add(String.valueOf(i));
            }
        }

        return resList;
    }
}
