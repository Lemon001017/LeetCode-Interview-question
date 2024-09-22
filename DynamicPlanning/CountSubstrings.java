package DynamicPlanning;

public class CountSubstrings {
    /**
     * 题目: 给定一个字符串，计算这个字符串中有多少个回文子串。
     */
    public static int countSubstrings(String s) {
        if (s == null || s.isEmpty()) return 0;
        int ans = 0;
        int n = s.length();
        // 枚举每个回文中心
        for (int i = 0; i < 2 * n - 1; i++) {
            int l = i / 2, r = i / 2 + i % 2;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                ans++;
                l--;
                r++;
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
        assertEqual(countSubstrings("abc"), 3, "1");
        assertEqual(countSubstrings("aaa"), 6, "2");
        assertEqual(countSubstrings("aaaa"), 10, "3");
    }
}
