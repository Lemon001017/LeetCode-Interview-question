package DynamicPlanning;

import java.util.Arrays;

public class CoinChange {
    /*
        题目: 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
             如果没有任何一种硬币组合能组成总金额，返回 -1。
             你可以认为每种硬币的数量是无限的。
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        if (dp[amount] > amount) return -1;
        else return dp[amount];
    }

    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
        assertEqual(new CoinChange().coinChange(new int[]{1, 2, 5}, 11), 3, "1");
        assertEqual(new CoinChange().coinChange(new int[]{2}, 3), -1, "2");
        assertEqual(new CoinChange().coinChange(new int[]{1}, 0), 0, "3");
        assertEqual(new CoinChange().coinChange(new int[]{1}, 1), 1, "4");
        assertEqual(new CoinChange().coinChange(new int[]{1}, 2), 2, "5");
    }
}
