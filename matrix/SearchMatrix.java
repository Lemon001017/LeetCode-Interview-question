package matrix;

public class SearchMatrix {
    /**
     * 题目: 搜索二维矩阵
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        for (int[] row : matrix) {
            if (search(row, target) != -1) {
                return true;
            }
        }
        return false;
    }

    public static int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + r >> 1;
            if (target == nums[mid]) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
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
        assertEqual(searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}}, 3), true, "1");
        assertEqual(searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}}, 13), false, "2");
        assertEqual(searchMatrix(new int[][]{{1}}, 1), true, "3");
    }
}
