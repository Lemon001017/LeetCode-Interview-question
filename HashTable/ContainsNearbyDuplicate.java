package HashTable;

import java.util.HashMap;
import java.util.Map;

public class ContainsNearbyDuplicate {
    /**
     * 给定一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个不同的索引 i 和 j ，使得 nums [i] = nums [j] ，并且 i 和 j 的差的绝对值最大为 k。
     */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(num) && i - map.get(num) <= k) {
                return true;
            }
            map.put(num, i);
        }
        return false;
    }

    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
        assertEqual(containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3), true, "1");
        assertEqual(containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1), true, "2");
        assertEqual(containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2), false, "3");
    }
}
