package DynamicPlanning;

public class RobTwo {
    /**
     * 题目: 打家劫舍 II
     */
    public static int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);
        int sum1 = 0, sum2 = 0;
        // 偷第一间屋子
        int[] dp = new int[n];
        for (int i = 2; i <= n - 2; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }
        sum1 = dp[n - 2] + nums[0];

        // 不偷第一间屋子
        dp[1] = nums[1];
        for (int i = 2; i <= n - 1; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }
        sum2 = dp[n - 1];

        return Math.max(sum1, sum2);
    }

    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
        assertEqual(rob(new int[]{2, 3, 2}), 3, "");
        assertEqual(rob(new int[]{1, 2, 3, 1}), 4, "");
        assertEqual(rob(new int[]{2, 7, 9, 3, 1}), 11, "");
    }
}
