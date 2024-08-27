package DynamicPlanning;

import java.util.List;

public class WordBreak {
    /*
        题目: 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
             注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
     */
    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (String word : wordDict) {
                int length = word.length();
                if (i >= length && s.substring(i - length, i).equals(word)) {
                    dp[i] = dp[i] || dp[i - length];
                }
            }
        }
        return dp[s.length()];
    }

    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
        assertEqual(wordBreak("leetcode", List.of("leet", "code")), true, "1");
        assertEqual(wordBreak("applepenapple", List.of("apple", "pen")), true, "2");
        assertEqual(wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat")), false, "3");
    }
}
