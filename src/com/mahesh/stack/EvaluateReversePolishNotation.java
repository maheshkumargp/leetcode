package com.mahesh.stack;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class EvaluateReversePolishNotation {

    public static int evalRPN(String[] tokens) {
        Set<String> validOperators = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
        Stack<String> resultStack = new Stack<>();
        for (String s : tokens) {
            if (validOperators.contains(s)) {
                Integer result;
                int first;
                int second;
                switch (s) {
                    case "+":
                        result = Integer.parseInt(resultStack.pop()) + Integer.parseInt(resultStack.pop());
                        resultStack.push(String.valueOf(result));
                        break;
                    case "-":
                        first = Integer.parseInt(resultStack.pop());
                        second = Integer.parseInt(resultStack.pop());
                        result = second - first;
                        resultStack.push(String.valueOf(result));
                        break;
                    case "*":
                        result = Integer.parseInt(resultStack.pop()) * Integer.parseInt(resultStack.pop());
                        resultStack.push(String.valueOf(result));
                        break;
                    case "/":
                        first = Integer.parseInt(resultStack.pop());
                        second = Integer.parseInt(resultStack.pop());
                        result = second / first;
                        resultStack.push(String.valueOf(result));
                        break;
                }
            } else {
                resultStack.push(s);
            }
        }
        return Integer.parseInt(resultStack.pop());
    }

    public static void main(String[] args) {
        //String[] token = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        String[] token =  {"4","3","-"};
        System.out.println("result - "+ evalRPN(token));

    }

}
