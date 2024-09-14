package ArrayAndString;

public class LengthOfLastWord {
    /*
        题目: 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中最后一个单词的长度。
     */
    public static int lengthOfLastWord(String s) {
        int ans = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ' && ans == 0) {
                continue;
            }
            if (s.charAt(i) == ' ') {
                return ans;
            }
            ans++;
        }
        return ans;
    }

    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
        assertEqual(lengthOfLastWord("Hello World"), 5, "");
        assertEqual(lengthOfLastWord("   fly me   to   the moon  "), 4, "");
        assertEqual(lengthOfLastWord("luffy is still joyboy"), 6, "");
    }
}
