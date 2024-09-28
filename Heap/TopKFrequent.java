package Heap;

import java.util.*;

public class TopKFrequent {
    /**
     * 题目: 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
     */
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(nums).forEach(num -> map.put(num, map.getOrDefault(num, 0) + 1));
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));

        queue.addAll(map.keySet());
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = queue.poll();
        }
        return ans;
    }

    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
        int[] ans = topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        assertEqual(ans[0], 1, "");
        assertEqual(ans[1], 2, "");
    }
}
