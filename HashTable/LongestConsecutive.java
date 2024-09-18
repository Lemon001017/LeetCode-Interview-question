package HashTable;

import java.util.Arrays;

public class LongestConsecutive {
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        Arrays.sort(nums);
        int ans = 1, sum = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 0 || nums[i] - nums[i - 1] == 1) {
                if (nums[i] - nums[i - 1] == 0) sum--;
                sum++;
            } else sum = 1;
            ans = Math.max(ans, sum);
        }
        return ans;
    }

    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
        assertEqual(longestConsecutive(new int[]{1, 2, 0, 1}), 3, "1");
        assertEqual(longestConsecutive(new int[]{1, 2, 3, 4}), 4, "2");
        assertEqual(longestConsecutive(new int[]{}), 0, "3");
    }
}
