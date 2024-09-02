package DoublePointer;

public class IsPalindrome {
    /*
        题目: 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个回文串 。
             字母和数字都属于字母数字字符。
             给你一个字符串 s，如果它是回文串 ，返回 true ；否则，返回 false 。
     */
    public static boolean isPalindrome(String s) {
        int n = s.length();
        int l = 0, r = n - 1;
        while (l < r) {
            while (l < r && !Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            }
            while (l < r && !Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            }
            if (l < r) {
                if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                    return false;
                }
                l++;
                r--;
            }
        }
        return true;
    }

    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
        assertEqual(isPalindrome("A man, a plan, a canal: Panama"), true, "1");
        assertEqual(isPalindrome("race a car"), false, "2");
        assertEqual(isPalindrome(" "), true, "3");
    }
}
