package leetcode;

public class SingleNumber {
    public int singleNumber(int[] A) {
        int a = 0;
        for(int i:A){
            a = a^i;
        }
        return a;
    }
}
