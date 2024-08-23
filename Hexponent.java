import java.util.Arrays;
import java.util.Collections;

public class Hexponent {
    /*
        题目: 给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数。计算并返回该研究者的 h 指数。
        根据维基百科上 h 指数的定义: h 代表“高引用次数”.一名科研人员的 h 指数是指他（她）至少发表了 h 篇论文,并且至少有 h 篇论文被引用次数大于等于h 。
        如果 h 有多种可能的值，h 指数是其中最大的那个。
     */
    public static int hIndex(int[] citations) {
        int n = citations.length;
        Arrays.sort(citations);
        for (int i = 0; i < n; i++) {
            if (citations[i] >= n - i) {
                return n - i;
            }
        }
        return 0;
    }

    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
        assertEqual(hIndex(citations), 3, "1");
        assertEqual(hIndex(new int[]{0}), 0, "2");
        assertEqual(hIndex(new int[]{1, 1, 1, 1}), 1, "3");
        assertEqual(hIndex(new int[]{1, 2, 3, 4, 5}), 3, "4");
    }
}
