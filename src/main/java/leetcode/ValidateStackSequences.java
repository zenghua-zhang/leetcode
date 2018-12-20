package leetcode;

import java.util.Stack;

public class ValidateStackSequences {

  public boolean validateStackSequences(int[] pushed, int[] popped) {
    if (pushed.length != popped.length) {
      return false;
    }

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> pp = new Stack<>();
    for (int i = popped.length - 1; i >= 0; i--) {
      pp.push(popped[i]);

    }

    for (int i : pushed) {
      stack.push(i);
      while (!stack.isEmpty() && !pp.isEmpty() && stack.peek().equals(pp.peek())) {

        pp.pop();
        stack.pop();
      }

    }

    return stack.isEmpty() && pp.isEmpty();
  }
}
