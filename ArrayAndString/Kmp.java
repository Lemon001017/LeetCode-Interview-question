package ArrayAndString;

public class Kmp {
    /*
        题目: 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
             如果 needle 不是 haystack 的一部分，则返回 -1 。
     */
    public static int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        if (haystack.length() < needle.length()) return -1;

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            boolean found = true;
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    found = false;
                    break;
                }
            }
            if (found) return i;
        }
        return -1;
    }

    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
        assertEqual(strStr("hello", "ll"), 2, "1");
        assertEqual(strStr("aaaaa", "bba"), -1, "2");
        assertEqual(strStr("", ""), 0, "3");
        assertEqual(strStr("a", "a"), 0, "4");
        assertEqual(strStr("abc", "c"), 2, "5");
    }
}
