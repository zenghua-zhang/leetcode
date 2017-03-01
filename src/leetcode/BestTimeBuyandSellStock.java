package leetcode;

import java.util.Arrays;

public class BestTimeBuyandSellStock {
    public int maxProfit(int[] prices) {
        if (prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int[] lowest = new int[prices.length];
        lowest[0] = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > lowest[i - 1]) {
                lowest[i] = lowest[i - 1];
            } else {
                lowest[i] = prices[i];
            }
        }
        
        for (int i = 0; i < prices.length; i++) {
            lowest[i] = prices[i] - lowest[i];
        }

        int ret = Integer.MIN_VALUE;
        for (int i : lowest) {
            ret = Math.max(i, ret);

        }
        return ret;
    }
    
    public static void main(String[] args){
        BestTimeBuyandSellStock a = new BestTimeBuyandSellStock();
        System.out.println(a.maxProfit(new int[]{9,1,2,3,45,6}));
    }
}
