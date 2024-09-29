package matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {
    /**
     * 题目: 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1;
        while (true) {
            for (int i = l; i <= r; i++) ans.add(matrix[t][i]);
            if (++t > b) break;

            for (int i = t; i <= b; i++) ans.add(matrix[i][r]);
            if (l > --r) break;

            for (int i = r; i >= l; i--) ans.add(matrix[b][i]);
            if (t > --b) break;

            for (int i = b; i >= t; i--) ans.add(matrix[i][l]);
            if (++l > r) break;
        }

        return ans;
    }

    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
        assertEqual(spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}), List.of(1, 2, 3, 6, 9, 8, 7, 4, 5), "1");
        assertEqual(spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}), List.of(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7), "2");
    }
}
