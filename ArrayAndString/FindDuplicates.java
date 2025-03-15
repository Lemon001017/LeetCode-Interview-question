package ArrayAndString;

import java.util.ArrayList;
import java.util.List;

public class findDuplicates {
    /**
     * 题目：找出数组中出现两次的数字
     */
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i + 1 != nums[i]) {
                ans.add(nums[i]);
            }
        }
        return ans;
    }

    public static void swap(int[] nums, int index1, int index2) {
        int t = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = t;
    }

    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> result = new ArrayList<>();
        result.add(3);
        result.add(2);
        assertEqual(findDuplicates(nums), result, "1");
    }
}
