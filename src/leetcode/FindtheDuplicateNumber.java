package leetcode;

public class FindtheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int l = nums.length-1;
        Long total = (long) ((1 + l) * l / 2);
        for (int i : nums) {
            total -= i;
        }
        
        total = -total;

        return Integer.valueOf(total.toString());
    }
}
