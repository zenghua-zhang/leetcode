package leetcode;

public class FindMinimuminRotatedSortedArray {
    public int findMin(int[] num) {

        int min = Integer.MAX_VALUE;
        int s = 0, e = num.length - 1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (num[s] <= num[mid]) {
                min = Math.min(num[s], min);
                s = mid + 1;
            } else {
                min = Math.min(num[mid], min);
                e = mid - 1;
            }
        }

        return min;
    }
}
