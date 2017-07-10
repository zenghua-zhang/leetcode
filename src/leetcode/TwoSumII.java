package leetcode;

public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length - 1;
        while (numbers[low] + numbers[high] != target && high > low) {
            if (numbers[low] + numbers[high] > target) {
                high--;
            } else if (numbers[low] + numbers[high] < target) {
                low++;
            }
        }
        return new int[] { low+1, high+1 };
    }
}
