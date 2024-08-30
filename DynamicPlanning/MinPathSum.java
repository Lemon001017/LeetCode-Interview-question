package DynamicPlanning;

public class MinPathSum {
    /*
        题目: 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
     */
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] f = new int[n];
        f[0] = grid[0][0];

        // 初始化第一行
        for (int i = 1; i < n; i++) {
            f[i] = f[i - 1] + grid[0][i];
        }

        for (int i = 1; i < m; i++) {
            f[0] += grid[i][0];
            for (int j = 1; j < n; j++) {
                f[j] = Math.min(f[j], f[j - 1]) + grid[i][j];
            }
        }

        return f[n - 1];
    }

    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
        assertEqual(minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}), 7, "1");
        assertEqual(minPathSum(new int[][]{{1, 2, 3}, {4, 5, 6}}), 12, "2");
        assertEqual(minPathSum(new int[][]{{1}}), 1, "3");
    }
}
