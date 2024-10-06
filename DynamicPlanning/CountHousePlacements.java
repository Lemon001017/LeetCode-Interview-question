package DynamicPlanning;

public class CountHousePlacements {
    /**
     * 题目: 一条街道上共有 n * 2 个 地块 ，街道的两侧各有 n 个地块。每一边的地块都按从 1 到 n 编号。每个地块上都可以放置一所房子。
     *      现要求街道同一侧不能存在两所房子相邻的情况，请你计算并返回放置房屋的方式数目。由于答案可能很大，需要对 109 + 7 取余后再返回。
     */
    public static int countHousePlacements(int n) {
        int mod = (int) 1e9 + 7;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % mod;
        }

        return (int) ((long) dp[n] * dp[n] % mod);
    }

    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
        assertEqual(countHousePlacements(1), 4, "");
        assertEqual(countHousePlacements(2), 9, "");
    }
}
