package ArrayAndString;

public class MaxSubarraySumCircular {
    /**
     * 题目: 给定一个长度为 n 的环形整数数组 nums ，返回 nums 的非空 子数组 的最大可能和 。
     */

    public static int maxSubarraySumCircular(int[] nums) {
        int ans1 = Integer.MIN_VALUE;
        int sumAll = 0;
        int sum1 = 0;
        int sum2 = 0;
        int minS = 0;
        int ans2 = 0;
        for (int x : nums) {
            sum1 = Math.max(x, x + sum1);
            ans1 = Math.max(ans1, sum1);
            sum2 = Math.min(x, x + sum2);
            minS = Math.min(minS, sum2);
            sumAll += x;
        }

        ans2 = sumAll - minS;
        if (minS == sumAll) {
            return ans1;
        } else {
            return Math.max(ans1, ans2);
        }
    }

    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
        assertEqual(maxSubarraySumCircular(new int[]{1, -2, 3, -2}), 3, "1");
        assertEqual(maxSubarraySumCircular(new int[]{5, -3, 5}), 10, "3");
        assertEqual(maxSubarraySumCircular(new int[]{3, -2, 2, -3}), 3, "4");
    }
}
