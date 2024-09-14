package ArrayAndString;

public class IntToRoman {
    /*
        题目: 将一个整数转换为罗马数字。
     */
    static int[] vals = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    static String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public static String intToRoman(int num) {
        StringBuffer ans = new StringBuffer();
        for (int i = 0; i < vals.length; i++) {
            int v = vals[i];
            String symbol = symbols[i];
            while (num >= v) {
                num -= v;
                ans.append(symbol);
            }
            if (num == 0) {
                break;
            }
        }
        return ans.toString();
    }

    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
        assertEqual(intToRoman(3), "III", "");
        assertEqual(intToRoman(4), "IV", "");
        assertEqual(intToRoman(9), "IX", "");
        assertEqual(intToRoman(58), "LVIII", "");
        assertEqual(intToRoman(1994), "MCMXCIV", "");
    }
}
