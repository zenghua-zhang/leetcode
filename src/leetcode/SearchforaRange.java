package leetcode;

public class SearchforaRange {
    public static void main(String[] args){
        int[] a = new int[]{1,4};
        SearchforaRange b = new SearchforaRange();
        b.searchRange(a, 4);
    }
    
    public int[] searchRange(int[] A, int target) {
        int s = -1, e = -1;
        if (A.length == 0) {
            return new int[] { s, e };
        }
        if(A.length == 1){
            if(A[0] == target){
                s = e = 0;
            }
            return new int[] { s, e };
        }
        int i = 0, j = A.length - 1;
        int mid = 0;
        while (i <= j) {
            mid = (i + j) / 2;
            if (A[mid] == target) {
                s = e = mid;
                break;
            } else if (target > A[mid]) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        if (s != -1) {
            while (s >= 0 && A[s] == target) {
                s--;
            }
            s++;
            while (e < A.length && A[e] == target) {
                e++;
            }
            e--;
        }

        return new int[] { s, e };
    }
}
