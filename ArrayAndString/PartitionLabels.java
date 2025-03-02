package ArrayAndString;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    public static List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        int length = s.length();
        for (int i = 0; i < length; i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        List<Integer> ans = new ArrayList<>();
        int l = 0, r = 0;
        for (int i = 0; i < length; i++) {
            r = Math.max(r, last[s.charAt(i) - 'a']);
            if (i == r) {
                ans.add(r - l + 1);
                l = r + 1;
            }
        }
        return ans;
    }

    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
        assertEqual(partitionLabels("ababcbacadefegdehijhklij"), List.of(9, 7, 8), "1");
        assertEqual(partitionLabels("eccbbbbdec"), List.of(10), "2");
        assertEqual(partitionLabels(""), List.of(), "3");
    }
}
