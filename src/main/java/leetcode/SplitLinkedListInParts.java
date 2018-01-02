package leetcode;

import model.ListNode;
import org.junit.Test;
import util.ListNodeHelper;

public class SplitLinkedListInParts {

  public ListNode[] splitListToParts(ListNode root, int k) {
    ListNode[] result = new ListNode[k];

    int count = count(root);
    for (int i = 1; i <= k; i++) {
      int mod = count % (k - i + 1);
      int num = count / (k - i + 1);
      if (mod != 0) {
        num++;
      }
      result[i - 1] = root;

      root = splitTail(root, num);

      count = count - num;
    }

    return result;
  }

  private static int count(ListNode node) {
    if (null == node) {
      return 0;
    }
    return 1 + count(node.next);
  }

  private static ListNode splitTail(ListNode root, int num) {
    if (null == root) {
      return null;
    }
    for (int i = 1; i < num && root != null; i++) {
      root = root.next;
    }
    if (root != null) {
      ListNode next = root.next;
      root.next = null;
      return next;
    }
    return null;
  }

  @Test
  public void test() {
    SplitLinkedListInParts sllip = new SplitLinkedListInParts();
    ListNode root = ListNodeHelper.genFromInt(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
    ListNode[] nodes = sllip.splitListToParts(root, 4);
    for (ListNode node : nodes) {
      ListNodeHelper.printListNode(node);
    }

  }


}
