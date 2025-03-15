package com.mahesh.design;

import java.util.List;
import java.util.Stack;

class MinStack {
    Stack<List<Integer>> minStack;
    int currMin;

    public MinStack() {
        minStack = new Stack<>();
        currMin = Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top());    // return 0
        System.out.println(minStack.getMin()); // return -2

    }

    public void push(int val) {
        currMin = Math.min(currMin, val);
        minStack.push(List.of(val, currMin));
    }

    public void pop() {
        minStack.pop();
        currMin = minStack.isEmpty() ? Integer.MAX_VALUE : minStack.peek().get(1);
    }

    public int top() {
        return minStack.peek().get(0);
    }

    public int getMin() {
        return minStack.peek().get(1);
    }
}
