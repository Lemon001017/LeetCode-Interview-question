package DoublePointer;

public class MaxArea {
    /*
        题目: 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
             找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
             返回容器可以储存的最大水量。
     */
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;
        while (l < r) {
            ans = Math.max(ans, Math.min(height[l], height[r]) * (r - l));
            if (height[l] <= height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return ans;
    }

    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
        assertEqual(new MaxArea().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}), 49, "1");
        assertEqual(new MaxArea().maxArea(new int[]{1, 1}), 1, "2");
        assertEqual(new MaxArea().maxArea(new int[]{4, 3, 2, 1, 4}), 16, "3");
    }
}
