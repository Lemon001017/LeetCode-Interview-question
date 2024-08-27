package ArrayAndString;

public class JumpGame {
    /*
        题目: 给你一个非负整数数组 nums ，你最初位于数组的第一个下标。数组中的每个元素代表你在该位置可以跳跃的最大长度。
             判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
     */
    public static boolean canJump(int[] nums) {
        int steps = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= steps) {
                steps = Math.max(steps, i + nums[i]);
                if (steps >= nums.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        assertEqual(canJump(nums), true, "1");
        nums = new int[]{3, 2, 1, 0, 4};
        assertEqual(canJump(nums), false, "2");
        nums = new int[]{0};
        assertEqual(canJump(nums), true, "3");
    }
}
