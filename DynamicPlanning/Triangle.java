package DynamicPlanning;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
    /**
     * 题目: 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
     */
    public static List<List<Integer>> generate(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || i == j) row.add(1);
                else row.add(ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j));
            }
            ans.add(row);
        }

        return ans;
    }

    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
        assertEqual(generate(5), new ArrayList<>(List.of(List.of(1), List.of(1, 1), List.of(1, 2, 1), List.of(1, 3, 3, 1), List.of(1, 4, 6, 4, 1))), "1");
        assertEqual(generate(1), new ArrayList<>(List.of(List.of(1))), "2");
        assertEqual(generate(0), new ArrayList<>(), "3");
    }
}
