package ArrayAndString;

public class TradeStockTwo {
    /*
        题目: 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
             在每一天，你可以决定是否购买和/或出售股票。你在任何时候最多只能持有一股股票。你也可以先购买，然后在同一天出售。
             返回 你能获得的最大利润 。
     */
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }

    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
        int prices[] = {7, 1, 5, 3, 6, 4};
        assertEqual(maxProfit(prices), 7, "");
        prices = new int[]{1, 2, 3, 4, 5};
        assertEqual(maxProfit(prices), 4, "");
        prices = new int[]{7, 6, 4, 3, 1};
        assertEqual(maxProfit(prices), 0, "");
    }

}
