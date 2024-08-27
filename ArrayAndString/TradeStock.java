package ArrayAndString;

public class TradeStock {
    /*
        题目: 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
             你只能选择某一天买入这只股票，并选择在未来的某一个不同的日子卖出该股票。设计一个算法来计算你所能获取的最大利润。
             返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
     */
    public static int maxProfit(int[] prices) {
        int max = 0, cost = Integer.MAX_VALUE;
        for (int price : prices) {
            cost = Math.min(cost, price);
            max = Math.max(max, price - cost);
        }
        return max;
    }

    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
        assertEqual(maxProfit(new int[]{7, 1, 5, 3, 6, 4}), 5, "1");
        assertEqual(maxProfit(new int[]{7, 6, 4, 3, 1}), 0, "2");
        assertEqual(maxProfit(new int[]{1, 2, 3, 4, 5}), 4, "3");
    }
}
