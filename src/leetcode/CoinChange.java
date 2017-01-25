package leetcode;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] keys = new int[amount + 1];

        for (int i = 1; i <= amount; i++) {
            int min = -1;
            for (int coin : coins) {
                if (i < coin || keys[i - coin] < 0) {
                    continue;
                }
                int step = keys[i - coin] + 1;
                min = min < 0 ? step : Math.min(min, step);
            }
            keys[i] = min;
        }

        return keys[amount];
    }

    public static void main(String[] args) {
        int[] coins = new int[] { 1, 2, 5 };
        CoinChange cc = new CoinChange();
        cc.coinChange(coins, 20);
    }
}
