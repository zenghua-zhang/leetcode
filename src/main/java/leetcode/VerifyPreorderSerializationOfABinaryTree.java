package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class VerifyPreorderSerializationOfABinaryTree {

  public boolean isValidSerialization(String preorder) {
    Queue<String> queue = new LinkedList<>();
    for (String s : preorder.split(",")) {
      queue.add(s.trim());
    }

    return helper(queue) && queue.isEmpty();
  }


  private boolean helper(Queue<String> queue) {
    if (queue.isEmpty()) {
      return false;
    }
    String val = queue.poll();
    if ("#".equals(val)) {
      return true;
    }
    return helper(queue) && helper(queue);
  }
}
