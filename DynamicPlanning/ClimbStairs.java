package DynamicPlanning;

public class ClimbStairs {
    /*
      题目: 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
           每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     */
    public static int climbStairs(int n) {
        int[] f = new int[n + 2];
        f[0] = 1;
        f[1] = 1;
        f[2] = 2;
        for (int i = 3; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }

    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
        assertEqual(climbStairs(2), 2, "1");
        assertEqual(climbStairs(3), 3, "2");
        assertEqual(climbStairs(4), 5, "3");
        assertEqual(climbStairs(5), 8, "4");
    }
}
