package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class RandomPickIndex {

    public class Solution {

        private Map<Integer, List<Integer>> map = new HashMap<>();

        public Solution(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                List<Integer> list = map.get(nums[i]);
                list = null == list ? new ArrayList<>() : list;
                list.add(i);

                map.put(nums[i], list);
            }
        }

        public int pick(int target) {
            List<Integer> list = map.get(target);

            return list.get(ThreadLocalRandom.current().nextInt(list.size()));
        }
    }

    @Test
    public void testNormal() {
        int[] nums = new int[]{1, 2, 3, 3, 3};
        Solution solution = new Solution(nums);
        assertThat(solution.pick(1), equalTo(0));
        assertThat(solution.pick(3), allOf(greaterThanOrEqualTo(2), lessThanOrEqualTo(4)));
    }
}
