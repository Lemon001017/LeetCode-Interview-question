package DynamicPlanning;

public class Rob {
    /*
        题目: 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
             如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
             给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
     */
    public static int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        int[] f = new int[n];
        f[0] = nums[0];
        f[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            f[i] = Math.max(f[i - 2] + nums[i], f[i - 1]);
        }
        return f[n - 1];
    }

    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
        assertEqual(rob(new int[]{1, 2, 3, 1}), 4, "1");
        assertEqual(rob(new int[]{2, 7, 9, 3, 1}), 12, "2");
        assertEqual(rob(new int[]{2, 1, 1, 2}), 4, "3");
    }
}
