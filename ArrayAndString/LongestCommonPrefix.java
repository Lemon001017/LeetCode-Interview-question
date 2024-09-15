package ArrayAndString;

public class LongestCommonPrefix {
    /*
        题目: 编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，返回空字符串 ""。
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        int length = strs[0].length();
        int cnt = strs.length;
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < cnt; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
        assertEqual(longestCommonPrefix(new String[]{"flower", "flow", "flight"}), "fl", "");
        assertEqual(longestCommonPrefix(new String[]{"dog", "racecar", "car"}), "", "");
        assertEqual(longestCommonPrefix(new String[]{"ab", "a"}), "a", "");
    }
}
