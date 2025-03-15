package DynamicPlanning;

public class MaxSumDivThree {
    /**
     * 题目: 给你一个整数数组 nums，请你找出并返回能被三整除的元素 最大和。
     */
    public static int maxSumDivThree(int[] nums) {
        int n = nums.length;
        int[][] f = new int[n + 1][3];
        f[0][1] = f[0][2] = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                f[i + 1][j] = Math.max(f[i][j], nums[i] + f[i][(j + nums[i]) % 3]);
            }
        }

        return f[n][0];
    }

    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 6, 5, 1, 8};
        int result = 18;
        assertEqual(maxSumDivThree(nums), result, "1");
    }
}
