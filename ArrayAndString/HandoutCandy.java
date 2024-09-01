package ArrayAndString;

import java.util.Arrays;

public class HandoutCandy {
    /*
        题目: n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
             你需要按照以下要求，给这些孩子分发糖果：
             每个孩子至少分配到 1 个糖果。
             相邻两个孩子评分更高的孩子会获得更多的糖果。
             请你给每个孩子分发糖果，计算并返回需要准备的最少糖果数目 。
     */
    public static int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);

        // 前向遍历处理递增序列
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // 后向遍历处理递减序列
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        // 计算总糖果数
        int totalCandies = 0;
        for (int candy : candies) {
            totalCandies += candy;
        }

        return totalCandies;
    }


    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
        assertEqual(candy(new int[]{1, 2, 2}), 4, "1");
        assertEqual(candy(new int[]{1, 0, 2}), 5, "2");
        assertEqual(candy(new int[]{1, 2, 1}), 4, "3");
        assertEqual(candy(new int[]{3, 2, 1, 1, 4, 3, 3}), 11, "4");
    }
}
