package com.mahesh.stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperature {

    record Pair(Integer index, Integer value) {
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Pair> myStack = new Stack<>();
        for(int i=0;i<temperatures.length;i++){
            while(!myStack.isEmpty() && myStack.peek().value() < temperatures[i]){
                Pair temp = myStack.pop();
                result[temp.index()]=i-temp.index();
            }
            myStack.push(new Pair(i,temperatures[i]));
        }

        while (!myStack.isEmpty()){
            result[myStack.pop().index()]=0;
        }
        return result;

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }
}
