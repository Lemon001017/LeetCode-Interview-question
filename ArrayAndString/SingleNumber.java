package ArrayAndString;

public class SingleNumber {
    /*
        题目:  给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     */
    public static int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }

    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
//        assertEqual(singleNumber(new int[]{2, 2, 1}), 1, "");
        assertEqual(singleNumber(new int[]{4, 1, 2, 1, 2}), 4, "");
        assertEqual(singleNumber(new int[]{1}), 1, "");
    }
}
