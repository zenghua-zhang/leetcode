package leetcode;

public class SearchInRotatedSortedArray {

  public int search(int[] nums, int target) {
    int s = 0, e = nums.length - 1;
    int mid = (s + e) / 2;

    while (s <= e) {
      int sNum = nums[s];
      int eNum = nums[e];
      int mNum = nums[mid];

      if (target == mNum) {
        return mid;
      }
      if ((mNum < eNum && (target < mNum || target > eNum))
          || (mNum > eNum && (target < mNum && target >= sNum))) {
        e = mid - 1;
      } else {
        s = mid + 1;
      }

      mid = (s + e) / 2;
    }

    return -1;
  }
}
