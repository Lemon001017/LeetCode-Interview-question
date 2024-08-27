package ArrayAndString;

public class RemoveDuplicates {
    /*
        题目:给你一个非严格递增排列的数组 nums ，请你原地删除重复出现的元素，使每个元素只出现一次 ，返回删除后数组的新长度。
        元素的相对顺序应该保持一致 。然后返回 nums 中唯一元素的个数。
     */

    public static int removeDuplicates(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            int t = nums[i];
            if (i == 0 || t != nums[i - 1]) {
                nums[k++] = t;
            }
        }
        return k;
    }

    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] nums2 = {1, 1, 2};
        assertEqual(removeDuplicates(nums1), 5, "");
        assertEqual(removeDuplicates(nums2), 2, "");
    }
}
