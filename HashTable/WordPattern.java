package HashTable;

import java.util.List;

public class WordPattern {
    /*
        题目: 给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
             这里的遵循指完全匹配，例如，pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。
     */
    public static boolean wordPattern(String pattern, String s) {
        List<String> words = List.of(s.split(" "));
        int n = pattern.length();
        if (n != words.size()) return false;
        for (int i = 0; i < n; i++) {
            if (pattern.indexOf(pattern.charAt(i)) != words.indexOf(words.get(i))) {
                return false;
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
        assertEqual(wordPattern("abba", "dog cat cat dog"), true, "1");
        assertEqual(wordPattern("abba", "dog cat cat fish"), false, "2");
        assertEqual(wordPattern("aaaa", "dog cat cat dog"), false, "3");
    }
}
