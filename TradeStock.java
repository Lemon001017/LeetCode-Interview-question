public class TradeStock {
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
