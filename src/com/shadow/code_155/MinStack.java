package com.shadow.code_155;

import java.util.Stack;

/**
 * 采用两个栈存储，一个保存值，一个保存最小值
 */
public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;  // 存放最小值

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (!minStack.isEmpty()) {
            int top = minStack.peek();
            if (top >= x) {
                minStack.push(x);
            }
        } else {
            minStack.push(x);
        }
    }

    public void pop() {
        int top = stack.pop();
        if (top == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("min=" + minStack.getMin());
        System.out.println("删除顶部元素");
        minStack.pop();
        System.out.println("查看顶部元素：" + minStack.top());
        System.out.println("查看最小值=" + minStack.getMin());
    }
}
