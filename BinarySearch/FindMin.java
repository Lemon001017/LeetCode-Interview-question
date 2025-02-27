package BinarySearch;

public class FindMin {
    public int findMin(int[] nums) {
        int n = nums.length;
        // 开区间（-1, n - 1）
        int l = -1;
        int r = n - 1;
        while (l + 1 < r) {
            int mid = l + r >> 1;
            if (nums[mid] < nums[n - 1]) {
                r = mid;
            } else {
                l = mid;
            }
        }
        return nums[r];
    }

    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
        assertEqual(new FindMin().findMin(new int[]{3, 4, 5, 1, 2}), 1, "1");
        assertEqual(new FindMin().findMin(new int[]{4, 5, 6, 7, 0, 1, 2}), 0, "2");
    }
}
