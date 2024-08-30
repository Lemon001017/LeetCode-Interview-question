package DynamicPlanning;

import java.util.List;

public class MinimumTotal {
    /*
        题目: 给定一个三角形 triangle ，找出自顶向下的最小路径和。
             每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
             也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
     */
    public static int minimumTotal(List<List<Integer>> triangle) {
        int[][] f = new int[triangle.size() + 1][triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--)
            for (int j = 0; j <= i; j++) {
                f[i][j] = Math.min(f[i + 1][j], f[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        return f[0][0];
    }

    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
        assertEqual(minimumTotal(List.of(List.of(2), List.of(3, 4), List.of(6, 5, 7), List.of(4, 1, 8, 3))), 11, "1");
        assertEqual(minimumTotal(List.of(List.of(-1), List.of(2, 3), List.of(1, -1, -3))), -1, "2");
        assertEqual(minimumTotal(List.of(List.of(-1), List.of(2, 3), List.of(1, -1, -3))), -1, "3");
    }
}
