package ArrayAndString;

public class RotateArray {
    /*
        题目: 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
     */
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        int[] temp1 = new int[k];
        int[] temp2 = new int[n - k];
        for (int i = n - k, j = 0; i < n; i++) {
            temp1[j++] = nums[i];
        }
        for (int i = 0, j = 0; i < n - k; i++) {
            temp2[j++] = nums[i];
        }
        for (int i = 0, j = 0; i < n; i++) {
            if (i < k) nums[i] = temp1[i];
            else nums[i] = temp2[j++];
        }
    }

    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int[] result = {5, 6, 7, 1, 2, 3, 4};
        rotate(nums, 3);
        for (int i = 0; i < nums.length; i++) {
            assertEqual(nums[i], result[i], "1");
        }

        nums = new int[]{-1, -100, 3, 99};
        result = new int[]{3, 99, -1, -100};
        rotate(nums, 2);
        for (int i = 0; i < nums.length; i++) {
            assertEqual(nums[i], result[i], "2");
        }

        nums = new int[]{1, 2};
        result = new int[]{2, 1};
        rotate(nums, 3);
        for (int i = 0; i < nums.length; i++) {
            assertEqual(nums[i], result[i], "3");
        }
    }
}
