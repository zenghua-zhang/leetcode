package leetcode;

import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.Test;

public class FindDuplicateFileinSystem {

  public List<List<String>> findDuplicate(String[] paths) {
    Map<String, List<String>> map = new HashMap<>();
    for (String files : paths) {
      String[] split = files.split("\\s+");
      String root = split[0];
      for (int i = 1; i < split.length; i++) {
        int left = split[i].indexOf("(");
        int right = split[i].indexOf(")");

        String content = split[i].substring(left + 1, right);

        List<String> list = map.getOrDefault(content, new ArrayList<>());
        list.add(root + "/" + split[i].substring(0, left));
        map.put(content, list);
      }
    }

    return map.values().stream().filter(l -> l.size() > 1).collect(Collectors.toList());
  }

  @Test
  public void test() {
    String[] str = new String[]{"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"};

    String file = "2.txt(efgh)";
    int left = file.indexOf("(");
    int right = file.indexOf(")");

    assertThat(file.substring(0, left), equalTo("2.txt"));
    assertThat(file.substring(left + 1, right), equalTo("efgh"));

    FindDuplicateFileinSystem system = new FindDuplicateFileinSystem();
    system.findDuplicate(str).forEach(l -> assertThat(l, anyOf(
        containsInAnyOrder("root/a/2.txt", "root/c/d/4.txt", "root/4.txt"),
        containsInAnyOrder("root/a/1.txt", "root/c/3.txt"))));

    List<List<String>> emptyList = system
        .findDuplicate(new String[]{"root/a 1.txt(abcd) 2.txt(efsfgh)", "root/c 3.txt(abdfcd)", "root/c/d 4.txt(efggdfh)"});

    assertThat(emptyList, empty());


  }


}
