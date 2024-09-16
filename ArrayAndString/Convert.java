package ArrayAndString;

import java.util.ArrayList;
import java.util.List;

public class Convert {
    /*
        题目: 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
     */
    public static String convert(String s, int numRows) {
        if (numRows <= 1) return s;
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }

        int i = 0, flag = -1;
        for (char c : s.toCharArray()) {
            rows.get(i).append(c);
            if (i == 0 || i == numRows - 1) flag = -flag;
            i += flag;
        }

        StringBuilder ans = new StringBuilder();
        for (StringBuilder row : rows) {
            ans.append(row);
        }
        return ans.toString();
    }

    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
        assertEqual(convert("PAYPALISHIRING", 3), "PAHNAPLSIIGYIR", "1");
        assertEqual(convert("PAYPALISHIRING", 4), "PINALSIGYAHRPI", "2");
        assertEqual(convert("A", 1), "A", "3");
    }
}
