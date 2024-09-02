package DoublePointer;

public class IsSubsequence {

    public static boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }

    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
        assertEqual(isSubsequence("acb", "ahbgdc"), false, "1");
        assertEqual(isSubsequence("axc", "ahbgdc"), false, "2");
        assertEqual(isSubsequence("", "ahbgdc"), true, "3");
        assertEqual(isSubsequence("a", ""), false, "4");
    }
}
