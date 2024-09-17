package HashTable;

public class IsAnagram {
    /*
        题目: 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     */
    public static boolean isAnagram(String s, String t) {
        int n = s.length();
        if (n != t.length()) return false;
        int[] cnt = new int[26];
        for (int i = 0; i < n; i++) cnt[s.charAt(i) - 'a']++;

        for (int i = 0; i < n; i++) {
            int num = cnt[t.charAt(i) - 'a']--;
            if (--num < 0) return false;
        }
        return true;
    }

    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
        assertEqual(isAnagram("anagram", "nagaram"), true, "1");
        assertEqual(isAnagram("rat", "car"), false, "2");
        assertEqual(isAnagram("a", "a"), true, "3");
    }
}
