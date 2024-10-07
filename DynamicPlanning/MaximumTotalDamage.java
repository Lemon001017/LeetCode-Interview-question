package DynamicPlanning;

import java.util.*;

public class MaximumTotalDamage {
    public static long maximumTotalDamage(int[] power) {
        Map<Integer, Integer> cnts = new HashMap<>();
        for (int num : power) {
            cnts.put(num, cnts.getOrDefault(num, 0) + 1);
        }

        List<Integer> powers = new ArrayList<>(cnts.keySet());
        Collections.sort(powers);
        int n = powers.size();
        long[] dp = new long[n + 1];
        for (int i = 1, j = 0; i <= n; i++) {
            int p = powers.get(i - 1);
            while (powers.get(j) < p - 2) j++;
            dp[i] = Math.max(dp[i - 1], dp[j] + (long) p * cnts.get(p));
        }
        return dp[n];
    }

    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
        long ans = maximumTotalDamage(new int[]{1, 1, 3, 4});
        assertEqual(maximumTotalDamage(new int[]{1, 1, 3, 4}), (long) 6, "");
        assertEqual(maximumTotalDamage(new int[]{7, 1, 6, 6}), (long) 13, "");
    }
}
