package DynamicPlanning;

public class CountGoodStrings {
    /**
     * 题目: 统计好字符串的数目
     */
    public static int countGoodStrings(int low, int high, int zero, int one) {
        final int MOD = (int) 1e9 + 7;
        int ans = 0;
        int[] dp = new int[high + 1];
        dp[0] = 1;
        for (int i = 1; i <= high; i++) {
            if (i >= zero) dp[i] = dp[i - zero];
            if (i >= one) dp[i] = (dp[i] + dp[i - one]) % MOD;
            if (i >= low) ans = (ans + dp[i]) % MOD;
        }

        return ans;
    }

    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
        assertEqual(countGoodStrings(3, 3, 1, 1), 8, "");
        assertEqual(countGoodStrings(2, 3, 1, 2), 5, "");
    }
}
