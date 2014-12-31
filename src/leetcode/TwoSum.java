package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, LinkedList<Integer>> map = new HashMap<Integer, LinkedList<Integer>>();
        for (int i = 1; i <= numbers.length; i++) {
            LinkedList<Integer> list = map.get(numbers[i - 1]) == null ? new LinkedList<Integer>()
                    : map.get(numbers[i - 1]);
            list.add(i);
            map.put(numbers[i - 1], list);
        }

        Arrays.sort(numbers);
        int high = numbers.length - 1;
        int low = 0;

        while (low < high) {
            int sum = numbers[low] + numbers[high];
            if (sum == target) {
                break;
            } else if (sum > target) {
                high--;
            } else {
                low++;
            }

        }

        int index1 = map.get(numbers[low]).poll();
        int index2 = map.get(numbers[high]).poll();
        if (index1 > index2) {
            int tmp = index2;
            index2 = index1;
            index1 = tmp;
        }

        return (new int[] { index1, index2 });
    }

    public static void main(String[] args) {
        TwoSum t = new TwoSum();
        int[] nums = new int[] { 5, 75, 25 };
        int[] a = t.twoSum(nums, 100);

        System.out.println(Arrays.toString(a));
    }
}
