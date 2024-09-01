package ArrayAndString;

public class CanCompleteCircuit {
    /*
        题目: 在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
             你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
             给定两个整数数组 gas 和 cost ，如果你可以按顺序绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则保证它是唯一的。
     */
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length, sum = 0, min = Integer.MAX_VALUE, minIndex = 0;
        for (int i = 0; i < n; i++) {
            sum += gas[i] - cost[i];
            if (sum < min) {
                min = sum;
                minIndex = i;
            }
        }
        if (sum < 0)    return -1;
        return (minIndex + 1) % n;
    }
    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
        assertEqual(canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}), 3, "1");
        assertEqual(canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3}), -1, "2");
        assertEqual(canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 5}), -1, "3");
    }
}
