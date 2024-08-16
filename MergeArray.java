import java.util.Arrays;

public class MergeArray {
    /*
        题目：给你两个按非递减顺序排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
        请你合并 nums2 到 nums1 中，使合并后的数组同样按非递减顺序排列。
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;

        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
        int[] a1 = {1, 2, 3, 0, 0, 0}, a2 = {2, 5, 6};
        int n = 3, m = 3;
        int result[] = {1, 2, 2, 3, 5, 6};
        merge(a1, m, a2, n);
        for (int i = 0; i < a1.length; i++) {
            System.out.print(a1[i] + " "); // output : 1 2 2 3 5 6
            assertEqual(a1[i], result[i], "merge error");
        }
    }


}


