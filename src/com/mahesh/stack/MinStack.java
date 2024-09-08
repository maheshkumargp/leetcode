package com.mahesh.stack;

import java.util.*;

public class MinStack {

    Map<Integer, Integer> minStack;
    Stack<Integer> stack;

    public MinStack() {
        minStack = new HashMap<>();
        stack = new Stack<>();
    }

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(512);
        obj.push(-1024);
        obj.push(-1024);
        obj.push(512);
        //System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.getMin());

    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(val);
            int top = stack.size() - 1;
            minStack.put(top, val);
        } else {
            int top = stack.size() - 1;
            Integer currMin = minStack.get(top);
            stack.push(val);
             top = stack.size() - 1;
            minStack.put(top, Integer.min(val, currMin));
        }

    }

    public void pop() {
        int top = stack.size() - 1;
        Integer val = stack.pop();
        minStack.remove(top);
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.get(stack.size()-1);
    }
}
