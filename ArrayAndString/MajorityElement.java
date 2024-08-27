package ArrayAndString;

import java.util.Arrays;

public class MajorityElement {
    /*
        题目: 找出数组中出现次数超过一半的元素
     */

    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[(nums.length - 1) / 2];
    }

    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
        assertEqual(majorityElement(new int[]{3, 2, 3}), 3, "");
        assertEqual(majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}), 2, "");
    }
}
