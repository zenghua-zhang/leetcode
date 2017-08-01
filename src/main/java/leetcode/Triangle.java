package leetcode;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.hamcrest.Matchers;
import org.junit.Test;

public class Triangle {

  public int minimumTotal(List<List<Integer>> triangle) {
    if (null == triangle || 0 == triangle.size()) {
      return 0;
    }
    List<List<Integer>> dp = new ArrayList<>();
    dp.add(triangle.get(0));
    for (int i = 1; i < triangle.size(); i++) {
      List<Integer> preRow = dp.get(i - 1);
      List<Integer> row = triangle.get(i);
      List<Integer> dpRow = new ArrayList<>();
      for (int j = 0; j < row.size(); j++) {
        int left = j == 0 ? Integer.MAX_VALUE : preRow.get(j - 1);
        int right = j == row.size() - 1 ? Integer.MAX_VALUE : preRow.get(j);
        dpRow.add(row.get(j) + Math.min(left, right));
      }
      dp.add(dpRow);
    }

    int min = Integer.MAX_VALUE;
    for (int a : dp.get(dp.size() - 1)) {
      min = Math.min(a, min);
    }

    return min;
  }

  @Test
  public void test() {
    List<List<Integer>> list = new ArrayList<>();
    list.add(asList(2));
    list.add(asList(3, 4));
    list.add(asList(6, 5, 7));
    list.add(asList(4, 1, 8, 3));

    assertThat(new Triangle().minimumTotal(list), Matchers.equalTo(11));
    list.clear();
    list.add(asList(3));
    assertThat(new Triangle().minimumTotal(list), Matchers.equalTo(3));

  }
}
