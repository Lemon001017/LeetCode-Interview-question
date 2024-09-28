package Heap;

public class FindKthLargest {
    /**
     * 题目: 数组中的第K个最大元素
     */
    public static int findKthLargest(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }

    public static void quickSort(int[] nums, int l, int r) {
        if (l >= r) return;
        int i = l - 1, j = r + 1;
        int x = nums[l + r >> 1];
        while (i < j) {
            do i++; while (nums[i] < x);
            do j--; while (nums[j] > x);
            if (i < j) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }
        quickSort(nums, l, j);
        quickSort(nums, j + 1, r);
    }

    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
        assertEqual(findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2), 5, "1");
        assertEqual(findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4), 4, "2");
        assertEqual(findKthLargest(new int[]{1, 2, 3, 4, 5, 6}, 1), 6, "3");
    }
}
