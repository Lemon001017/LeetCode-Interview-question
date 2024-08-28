package DynamicPlanning;

public class LengthOfLIS {
    /*
        题目: 给定一个无序的整数数组，找到其中最长上升子序列的长度。
     */
    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 1) return 1;

        int[] f = new int[nums.length];
        int ans = 0;
        f[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            f[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
            ans = Math.max(ans, f[i]);
        }
        return ans;
    }

    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
        assertEqual(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}), 4, "1");
        assertEqual(lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}), 4, "2");
        assertEqual(lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7}), 1, "3");
        assertEqual(lengthOfLIS(new int[]{4, 10, 4, 3, 8, 9}), 3, "4");
        assertEqual(lengthOfLIS(new int[]{0}), 1, "5");
    }
}
