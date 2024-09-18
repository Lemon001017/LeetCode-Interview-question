package HashTable;

public class IsHappy {
    /**
     * 判断一个数是否是快乐数
     */
    public static boolean isHappy(int n) {
        int slow = n;
        int fast = getNext(n);
        while (fast != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        if (fast == 1) {
            return true;
        } else {
            return false;
        }
    }

    public static int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int d = n % 10;
            sum += d * d;
            n /= 10;
        }
        return sum;
    }


    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
        assertEqual(isHappy(19), true, "1");
        assertEqual(isHappy(2), false, "2");
        assertEqual(isHappy(1), true, "3");
    }
}
