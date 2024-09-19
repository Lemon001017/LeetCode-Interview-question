package Stack;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class IsValid {
    /**
     * 题目: 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     */
    private static final Map<Character, Character> map = new HashMap<>() {
        {
            put('{', '}');
            put('[', ']');
            put('(', ')');
            put('?', '?');
        }
    };

    public static boolean isValid(String s) {
        if (!s.isEmpty() && !map.containsKey(s.charAt(0)))
            return false;
        LinkedList<Character> stk = new LinkedList<>();
        stk.add('?');
        for (Character c : s.toCharArray()) {
            if (map.containsKey(c)) {
                stk.addLast(c);
            } else if (map.get(stk.removeLast()) != c) {
                return false;
            }
        }
        return stk.size() == 1;
    }

    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
        assertEqual(isValid("()"), true, "1");
        assertEqual(isValid("()[]{}"), true, "2");
        assertEqual(isValid("(]"), false, "3");
        assertEqual(isValid("([)]"), false, "4");
        assertEqual(isValid("{[]}"), true, "5");
    }
}
