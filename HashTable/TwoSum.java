package HashTable;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    /*
        题目: 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
             你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
             你可以按任意顺序返回答案。
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int[] res = twoSum(nums, 9);
        assertEqual(res[0], 1, "1");
        assertEqual(res[1], 0, "2");

        nums = new int[]{3, 2, 4};
        res = twoSum(nums, 6);
        assertEqual(res[0], 2, "3");
        assertEqual(res[1], 1, "4");
    }
}
