package leetcode;

import org.hamcrest.Matchers;
import org.junit.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class RandomPickIndex {

    public class Solution {

        private Map<Integer, List<Integer>> map = new HashMap<>();

        public Solution(int[] nums) {
            
        }

        public int pick(int target) {


            return 0;
        }
    }

    public void testNormal() {
        int[] nums = new int[]{1, 2, 3, 3, 3};
        Solution solution = new Solution(nums);
        assertThat(solution.pick(1), equalTo(0));
        assertThat(solution.pick(3), allOf(greaterThanOrEqualTo(2), lessThanOrEqualTo(4)));

    }


}
