package SlidingWindow;

public class MinSubArrayLen {
    /**
     * 题目: 给定一个含有 n 个正整数的数组和一个正整数 target 。找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 。如果不存在符合条件的子数组，返回 0 。
     */
    public static int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int l = 0, r = 0, sum = 0;
        while (r < nums.length) {
            sum += nums[r];
            while (sum >= target) {
                ans = Math.min(ans, r - l + 1);
                sum -= nums[l++];
            }
            r++;
        }
        if (ans == Integer.MAX_VALUE) {
            return 0;
        } else {
            return ans;
        }
    }

    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
        assertEqual(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}), 2, "1");
        assertEqual(minSubArrayLen(4, new int[]{1, 4, 4}), 1, "2");
        assertEqual(minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}), 0, "3");
    }
}
