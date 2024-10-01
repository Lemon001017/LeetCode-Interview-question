package BinarySearch;

public class SearchSelectionArray {
    /**
     * 题目: 搜索旋转排序数组
     */
    public static int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[nums.length - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
        assertEqual(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0), 4, "1");
        assertEqual(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3), -1, "2");
        assertEqual(search(new int[]{1}, 0), -1, "3");
    }
}
