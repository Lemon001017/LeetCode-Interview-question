package ArrayAndString;

public class RomanToInt {
    /*
        题目: 给定一个罗马数字，将其转换成整数。
     */
    public static int romanToInt(String s) {
        int ans = 0;
        int pre = transform(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int num = transform(s.charAt(i));
            if (pre < num) ans -= pre;
            else ans += pre;
            pre = num;
        }
        ans += pre;
        return ans;
    }

    private static int transform(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
        assertEqual(romanToInt("III"), 3, "");
        assertEqual(romanToInt("IV"), 4, "");
        assertEqual(romanToInt("IX"), 9, "");
    }
}
