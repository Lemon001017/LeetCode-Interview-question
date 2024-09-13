package HashTable;

public class IsIsomorphic {
    /*
        题目: 给定两个字符串 s 和 t ，判断它们是否是同构的。
             如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
             每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
     */
    public static boolean isIsomorphic(String s, String t) {
        for (int i = 0; i < s.length(); i++) {
            char s1 = s.charAt(i);
            char t1 = t.charAt(i);
            if (s.indexOf(s1) != t.indexOf(t1)) {
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
        assertEqual(isIsomorphic("foo", "bar"), false, "");
        assertEqual(isIsomorphic("paper", "title"), true, "");
    }
}
