package leetcode;

public class FindPeakElement {
    public int findPeakElement(int[] num) {
        int r = 0;
        int compile = num[r];
        int length = num.length - 1;
        while (true) {
            if (r >= length) {
                break;
            }
            if (compile < num[r+1]) {
                compile = num[r+1];
            }else{
                break;
            }
            r++;

        }

        return r;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        FindPeakElement f = new FindPeakElement();
        System.out.println(f.findPeakElement(new int[] { 1, 2, 1, 1, 2, 3, 11,
                0 }));

    }

}
