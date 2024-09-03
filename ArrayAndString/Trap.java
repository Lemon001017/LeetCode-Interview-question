package ArrayAndString;

public class Trap {
    /*
        题目: 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     */
    public static int trap(int[] height) {
        int ans = 0;
        int l = 0, r = height.length - 1;
        int lm = 0, rm = 0;
        while (l < r) {
            lm = Math.max(lm, height[l]);
            rm = Math.max(rm, height[r]);
            if (height[l] < height[r]) {
                ans += lm - height[l++];
            } else {
                ans += rm - height[r--];
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
        assertEqual(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}), 6, "1");
        assertEqual(trap(new int[]{4,2,0,3,2,5}), 9, "2");
        assertEqual(trap(new int[]{}), 0, "3");
    }
}
