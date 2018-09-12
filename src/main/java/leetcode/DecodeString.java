package leetcode;

import java.util.LinkedList;

public class DecodeString {

  public String decodeString(String s) {
    LinkedList<Integer> numbers = new LinkedList<>();
    LinkedList<StringBuilder> strs = new LinkedList<>();

    StringBuilder number = new StringBuilder();
    strs.push(new StringBuilder());
    for (char c : s.toCharArray()) {
      if (Character.isDigit(c)) {
        // is number
        number.append(c);

      } else if (c == '[') {
        // into number stack
        numbers.push(Integer.valueOf(number.toString()));
        number = new StringBuilder();

        strs.push(new StringBuilder());
      } else if (c == ']') {
        // pop number and cal with strs stack
        StringBuilder sb = strs.pop();
        int repeat = numbers.pop();
        for (int i = 0; i < repeat; i++) {
          strs.peekFirst().append(sb);
        }

      } else {
        // letter
        strs.peekFirst().append(c);
      }
    }

    return strs.peekFirst().toString();
  }


}
