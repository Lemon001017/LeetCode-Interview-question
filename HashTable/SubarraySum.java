package HashTable;

import java.util.HashMap;
import java.util.Map;

public class SubarraySum {
    public static int subarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int preSum = 0, ans = 0;
        for (int num : nums) {
            preSum += num;
            if (map.containsKey(preSum - k)) {
                ans += map.get(preSum - k);
            }
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return ans;
    }

    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
        assertEqual(subarraySum(new int[]{1, 1, 1}, 2), 2, "");
        assertEqual(subarraySum(new int[]{1, 2, 3}, 3), 2, "");
    }
}
