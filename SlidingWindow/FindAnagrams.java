package SlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAnagrams {
    /**
     * 题目: 给定两个字符串 s 和 p，找到 s 中所有 p 的异位词的子串，返回这些子串的起始索引。
     */
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int m = s.length(), n = p.length();
        if (n > m) return ans;

        char[] chars1 = p.toCharArray();
        Arrays.sort(chars1);

        for (int i = 0; i <= m - n; i++) {
            String str = s.substring(i, i + n);
            char[] chars2 = str.toCharArray();
            Arrays.sort(chars2);
            if (Arrays.equals(chars1, chars2)) {
                ans.add(i);
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
        assertEqual(findAnagrams("cbaebabacd", "abc"), new ArrayList<>(Arrays.asList(0, 6)), "1");
        assertEqual(findAnagrams("abab", "ab"), new ArrayList<>(Arrays.asList(0, 1, 2)), "2");
        assertEqual(findAnagrams("ab", "ab"), new ArrayList<>(Arrays.asList(0)), "3");
    }
}
