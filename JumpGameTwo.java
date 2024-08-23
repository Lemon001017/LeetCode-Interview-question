public class JumpGameTwo {
    /*
        题目: 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
        每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
        返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
     */
    public static int jump(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int steps = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                steps++;
                end = maxPosition;
            }
        }

        return steps;
    }

    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
        assertEqual(jump(new int[]{2, 3, 1, 1, 4}), 2, "1");
        assertEqual(jump(new int[]{2, 3, 0, 1, 4}), 2, "2");
        assertEqual(jump(new int[]{1, 2, 3}), 2, "3");
        assertEqual(jump(new int[]{1, 1, 1, 1}), 3, "4");
    }
}
