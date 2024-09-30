package BinarySearch;

public class SearchInsert {
    /**
     * 题目: 搜索插入位置
     */
    public static int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + r >> 1;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
        assertEqual(searchInsert(new int[]{1, 3, 5, 6}, 5), 2, "1");
        assertEqual(searchInsert(new int[]{1, 3, 5, 6}, 2), 1, "2");
        assertEqual(searchInsert(new int[]{1, 3, 5, 6}, 7), 4, "3");
    }
}
