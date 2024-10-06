package DynamicPlanning;

public class DeleteAndEarn {
    /**
     * 题目: 给你一个整数数组 nums ，你可以对它进行一些操作。
     *      每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i] + 1 的元素。
     *      开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
     */
    public static int deleteAndEarn(int[] nums) {
        int max = nums[0];
        for (int num : nums) {
            max = Math.max(max, num);
        }

        int[] sum = new int[max + 1];
        for (int num : nums) {
            sum[num] += num;
        }

        int[] dp = new int[max + 1];
        dp[0] = sum[0];
        dp[1] = Math.max(sum[0], sum[1]);

        for (int i = 2; i <= max; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + sum[i]);
        }

        return dp[max];
    }

    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
        assertEqual(deleteAndEarn(new int[]{3, 4, 2}), 6, "");
        assertEqual(deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4}), 9, "");
    }
}
