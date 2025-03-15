package com.mahesh.other;

import java.util.Stack;

public class ValidParanthesis {


    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (Character c : s.toCharArray()) {
            if (c == ')') {
                if (stack.isEmpty()) return false;
                Character stTop = stack.pop();
                if (stTop != '(') return false;
            } else if (c == ']') {
                if (stack.isEmpty()) return false;
                Character stTop = stack.pop();
                if (stTop != '[') return false;
            } else if (c == '}') {
                if (stack.isEmpty()) return false;
                Character stTop = stack.pop();
                if (stTop != '{') return false;
            } else {
                stack.push(c);
            }

        }
        return stack.isEmpty();

    }

    public static void main(String[] args) {
        // System.out.println(isValid("(){}}{"));
        System.out.println(isValid("([])"));
        System.out.println(isValid("(]"));
    }
}
