package DynamicPlanning;

public class NumSquares {
    /**
     * 题目: 给定一个正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。
     */
    public static int numSquares(int n) {
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int minNum = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                minNum = Math.min(minNum, f[i - j * j]);
            }
            f[i] = minNum + 1;
        }
        return f[n];
    }

    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
        assertEqual(numSquares(12), 3, "1");
        assertEqual(numSquares(13), 2, "2");
        assertEqual(numSquares(1), 1, "3");
    }
}
