package BinarySearch;

public class FindPeakElement {
    /**
     *  题目：寻找峰值
     */
    public static int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] < nums[mid + 1]) {
                l = mid + 1;
            } else {
                r = mid;
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
        assertEqual(findPeakElement(new int[]{1, 2, 3, 1}), 2, "1");
        assertEqual(findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4}), 5, "2");
        assertEqual(findPeakElement(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}), 9, "3");
    }
}
