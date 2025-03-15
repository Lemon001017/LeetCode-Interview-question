package SlidingWindow;

public class NumSubarrayProductLessThanK {
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int ans = 0;
        int prod = 1;
        int l = 0, r = 0;
        while (r < nums.length) {
            prod *= nums[r];
            while (prod >= k) {
                prod /= nums[l++];
            }
            ans += r - l + 1;
            r++;
        }

        return ans;
    }

    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 6};
        assertEqual(numSubarrayProductLessThanK(nums, 100), 8, "1");
    }
}
