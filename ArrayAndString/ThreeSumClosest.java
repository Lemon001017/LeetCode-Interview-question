package ArrayAndString;

import java.util.Arrays;

public class ThreeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (Math.abs(target - sum) < Math.abs(target - ans)) {
                    ans = sum;
                }

                if (sum > target) {
                    r--;
                } else if (sum < target) {
                    l++;
                } else {
                    return ans;
                }
            }
        }

        return ans;
    }
    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
        assertEqual(threeSumClosest(new int[]{-1, 2, 1, -4}, 1), 2, "");
        assertEqual(threeSumClosest(new int[]{0, 2, 1, -3}, 1), 0, "");
        assertEqual(threeSumClosest(new int[]{0, 2, 1, -3}, 3), 3, "");
    }
}
