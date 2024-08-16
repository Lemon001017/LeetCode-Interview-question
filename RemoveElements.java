public class RemoveElements {
    /*
        题目：给你一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素。元素的顺序可能发生改变。然后返回 nums 中与 val 不同的元素的数量。
        假设 nums 中不等于 val 的元素数量为 k
        结果返回k
     */
    public static int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k++] = nums[i];
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
        int[] nums1 = {3, 2, 2, 3}, nums2 = {0, 1, 2, 2, 3, 0, 4, 2};
        assertEqual(removeElement(nums1, 3), 2, "1");
        assertEqual(removeElement(nums2, 2), 5, "2");
    }
}
