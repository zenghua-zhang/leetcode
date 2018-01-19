package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;

public class ReplaceWords {

  public String replaceWords(List<String> dict, String sentence) {
    DictTree root = new DictTree();
    for (String s : dict) {
      root.add(s, 0);
    }

    String[] splited = sentence.split("\\s+");

    List<String> strList = new ArrayList<>();
    for (String s : splited) {
      strList.add(root.find(s));
    }
    return strList.stream().collect(Collectors.joining(" "));
  }

  class DictTree {

    private boolean isEnd = false;

    private DictTree[] dictTrees = new DictTree[26];

    void add(String s, int pos) {
      if (pos == s.length()) {
        isEnd = true;
        return;
      }
      char c = s.charAt(pos);
      DictTree charPos = dictTrees[c - 'a'];
      if (charPos == null) {
        charPos = new DictTree();
        dictTrees[c - 'a'] = charPos;
      }
      charPos.add(s, pos + 1);
    }

    String find(String s) {
      DictTree tree = this;
      StringBuilder sb = new StringBuilder();
      for (char c : s.toCharArray()) {
        tree = tree.dictTrees[c - 'a'];
        if (tree == null) {
          return s;
        }
        sb.append(c);
        if (tree.isEnd) {
          return sb.toString();
        }
      }

      return s;
    }
  }

  @Test
  public void test() {
    DictTree root = new DictTree();
    root.add("abc", 0);
    root.add("adb", 0);

    System.out.println(root.find("ab"));
    System.out.println(root.find("adbbbb"));
    System.out.println(root.find("uye"));
    System.out.println(root.find("cba"));

  }
}
