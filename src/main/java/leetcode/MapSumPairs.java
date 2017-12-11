package leetcode;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class MapSumPairs {

  class MapSum {

    TrieTreeNode root;

    public MapSum() {
      root = new TrieTreeNode(null);
    }

    public void insert(String key, int val) {
      TrieTreeNode node = root;
      for (char c : key.toCharArray()) {
        node = node.insert(c);
      }
      node.setVal(val);
    }

    public int sum(String prefix) {
      TrieTreeNode node = root;
      for (char c : prefix.toCharArray()) {
        try {
          node = node.getSubNodes()[c - 'a'];
        } catch (NullPointerException npe) {
          return 0;
        }
      }

      return sum(node);
    }

    private int sum(TrieTreeNode node) {
      if (null == node) {
        return 0;
      }
      int sum = node.getVal();

      for (TrieTreeNode sub : node.getSubNodes()) {
        sum += sum(sub);
      }

      return sum;

    }


    private class TrieTreeNode {


      private TrieTreeNode[] subNodes = new TrieTreeNode[26];


      private int val = 0;

      private Character Character;

      private TrieTreeNode(Character c) {
        Character = c;
      }

      public int getVal() {
        return val;
      }

      public void setVal(int val) {
        this.val = val;
      }

      public TrieTreeNode[] getSubNodes() {
        return subNodes;
      }


      public TrieTreeNode insert(Character sub) {
        TrieTreeNode subNode = subNodes[sub - 'a'];
        if (null == subNode) {
          subNode = new TrieTreeNode(sub);
          subNodes[sub - 'a'] = subNode;
        }
        return subNode;
      }


    }

  }

  @Test
  public void test() {
    MapSum mapSum = new MapSum();
    mapSum.insert("apple", 3);
    assertThat(mapSum.sum("ap"), is(3));
    mapSum.insert("apple", 6);
    assertThat(mapSum.sum("ap"), is(6));
    mapSum.insert("app", 2);
    assertThat(mapSum.sum("ap"), is(8));

  }
}
