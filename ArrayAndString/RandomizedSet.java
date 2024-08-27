package ArrayAndString;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {
    /*
        题目: 实现RandomizedSet类：
             bool insert(int val) 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false 。
             bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。
             int getRandom() 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。每个元素应该有相同的概率被返回。
             你必须实现类的所有函数，并满足每个函数的平均时间复杂度为 O(1) 。
     */
    static int[] nums = new int[200010];
    Random random = new Random();
    Map<Integer, Integer> map = new HashMap<>();
    int idx = -1;

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        nums[++idx] = val;
        map.put(val, idx);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int newIdx = map.remove(val);
        if (newIdx != idx) {
            map.put(nums[idx], newIdx);
        }
        nums[newIdx] = nums[idx--];
        return true;
    }

    public int getRandom() {
        return nums[random.nextInt(idx + 1)];
    }

    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        assertEqual(randomizedSet.insert(1), true, "1");
        assertEqual(randomizedSet.remove(2), false, "2");
        assertEqual(randomizedSet.insert(2), true, "3");
        assertEqual(randomizedSet.remove(1), true, "4");
        assertEqual(randomizedSet.getRandom(), 2, "5");
    }
}
