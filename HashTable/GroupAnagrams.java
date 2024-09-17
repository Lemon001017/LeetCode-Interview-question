package HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    /**
     *  题目: 给定一个字符串数组 strs ，将 变位词 组合在一起。 可以按任意顺序返回结果列表。
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String ,List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String str_s = String.valueOf(chars);
            if (map.containsKey(str_s)) {
                map.get(str_s).add(str);
            } else {
                List<String> ls = new ArrayList<>();
                ls.add(str);
                map.put(str_s, ls);
            }
        }
        return new ArrayList<>(map.values());
    }
    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {

    }
}
