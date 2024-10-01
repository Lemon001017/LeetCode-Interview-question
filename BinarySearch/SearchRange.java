package BinarySearch;

public class SearchRange {
    /**
     * 题目: 在排序数组中查找元素的第一个和最后一个位置
     */
    public static int[] searchRange(int[] nums, int target) {
        int l = search(nums, target);
        if (l == nums.length || nums[l] != target) {
            return new int[]{-1, -1};
        }

        int r = search(nums, target + 1) - 1;
        return new int[]{l, r};
    }

    private static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
        int[] ans = searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        assertEqual(ans[0], 3, "1");
        assertEqual(ans[1], 4, "2");
    }
}
