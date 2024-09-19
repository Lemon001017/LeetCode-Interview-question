package Stack;

import java.util.Stack;

public class MinStack {
    /**
     * 题目: 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
     * push(x) —— 将元素 x 推入栈中。
     * pop()— 删除栈顶的元素。
     * top()— 获取栈顶元素。
     * getMin()— 检索栈中的最小元素。
     */
    private final Stack<Integer> stk;
    private final Stack<Integer> minStk;

    public MinStack() {
        stk = new Stack<>();
        minStk = new Stack<>();
    }

    public void push(int val) {
        stk.push(val);
        if (minStk.isEmpty() || val <= minStk.peek()) {
            minStk.push(val);
        }
    }

    public void pop() {
        if (stk.pop().equals(minStk.peek())) {
            minStk.pop();
        }
    }

    public int top() {
        return stk.peek();
    }

    public int getMin() {
        return minStk.peek();
    }

    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        assertEqual(minStack.getMin(), -3, "1");
        minStack.pop();
        assertEqual(minStack.top(), 0, "2");
        assertEqual(minStack.getMin(), -2, "3");
    }
}
