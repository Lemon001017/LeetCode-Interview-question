package DynamicPlanning;

public class LongestCommonSubsequence {
    /**
     * 题目: 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
     */
    public static int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        int[][] f = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                } else {
                    f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                }
            }
        }
        return f[n][m];
    }

    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
        assertEqual(longestCommonSubsequence("abcde", "ace"), 3, "1");
        assertEqual(longestCommonSubsequence("abc", "abc"), 3, "2");
        assertEqual(longestCommonSubsequence("abc", "def"), 0, "3");
    }
}
