package DoublePointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    /*
        题目: 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j , i != k 且 j != k ，
        同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组（不重复）。
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for (int k = 0; k < nums.length - 2; k++) {
            if (nums[k] > 0) break;
            if (k > 0 && nums[k] == nums[k - 1]) continue;
            int i = k + 1, j = nums.length - 1;
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum < 0) {
                    while (i < j && nums[i] == nums[++i]) ;
                } else if (sum > 0) {
                    while (i < j && nums[j] == nums[--j]) ;
                } else {
                    ans.add(List.of(nums[k], nums[i], nums[j]));
                    while (i < j && nums[i] == nums[++i]) ;
                    while (i < j && nums[j] == nums[--j]) ;
                }
            }
        }
        return ans;
    }

    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
        assertEqual(new ThreeSum().threeSum(new int[]{-1, 0, 1, 2, -1, -4}), List.of(List.of(-1, -1, 2), List.of(-1, 0, 1)), "1");
        assertEqual(new ThreeSum().threeSum(new int[]{}), List.of(), "2");
        assertEqual(new ThreeSum().threeSum(new int[]{0}), List.of(), "3");
        assertEqual(new ThreeSum().threeSum(new int[]{0, 0, 0}), List.of(List.of(0, 0, 0)), "4");
        assertEqual(new ThreeSum().threeSum(new int[]{-2, 0, 1, 1, 2}), List.of(List.of(-2, 0, 2), List.of(-2, 1, 1)), "5");
    }
}
