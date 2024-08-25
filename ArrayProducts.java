public class ArrayProducts {
    /*
        题目: 给你一个整数数组 nums ，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。(不能使用除法)
     */
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return new int[0];
        }
        int[] ans = new int[n];
        ans[0] = 1;
        int tmp = 1;

        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }

        for (int i = n - 2; i >= 0; i--) {
            tmp *= nums[i + 1];
            ans[i] *= tmp;
        }
        return ans;
    }

    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] ans = productExceptSelf(nums);
        int[] result = {24, 12, 8, 6};
        for (int i = 0; i < ans.length; i++) {
            assertEqual(ans[i], result[i], "");
        }
    }
}
