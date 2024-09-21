package SlidingWindow;

import java.util.HashSet;

public class LengthOfLongestSubstring {
    /**
     * 题目: 给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
     */
    public static int lengthOfLongestSubstring(String s) {
        int ans = 0;
        HashSet<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();
        for (int l = 0, r = 0; r < chars.length; r++) {
            while (set.contains(chars[r])) {
                set.remove(chars[l++]);
            }
            set.add(chars[r]);
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }

    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
        assertEqual(lengthOfLongestSubstring("abcabcbb"), 3, "1");
        assertEqual(lengthOfLongestSubstring("bbbbb"), 1, "2");
        assertEqual(lengthOfLongestSubstring("pwwkew"), 3, "3");
    }
}
