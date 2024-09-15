package ArrayAndString;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseWords {
    /*
        题目: 给定一个字符串，逐个翻转字符串中的每个单词。
     */
    public static String reverseWords(String s) {
        s = s.trim();
        List<String> ans = Arrays.asList(s.split("\\s+"));
        Collections.reverse(ans);
        return String.join(" ", ans);
    }

    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
        assertEqual(reverseWords("the sky is blue"), "blue is sky the", "");
        assertEqual(reverseWords("  hello world!  "), "world! hello", "");
        assertEqual(reverseWords("a good   example"), "example good a", "");
    }
}
