package com.mahesh.queue;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class OpenTheLock {

    public static int openLock(String[] deadends, String target) {
        HashSet<String> deadendSet = new HashSet<>();
        Collections.addAll(deadendSet, deadends);
        Queue<String> numbers = new LinkedList<>();
        addToQueue(numbers, "0000");
        HashSet<String> visited = new HashSet<>();
        int count = 1;
        while (!numbers.isEmpty()) {
            int size = numbers.size();
            for (int i = 0; i < size; i++) {
                String curr = numbers.poll();
                if (target.equals( curr)) {
                    return count;
                }
                if (!deadendSet.contains(curr) && !visited.contains(curr)) {
                    visited.add(curr);
                    addToQueue(numbers, curr);
                }
            }
            count++;
        }

        return -1;

    }

    private static void addToQueue(Queue<String> numbers, String number) {
        for (int i = 0; i < 4; i++) {
            numbers.offer(flipNext(number, i));
            numbers.offer(flipPrevious(number, i));
        }
    }

    private static String flipPrevious(String number, int pos) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            if (i == pos) {
                sb.append(getPrevious(number.charAt(i)));
            } else {
                sb.append(number.charAt(i));
            }
        }
        return sb.toString();
    }

    private static int getPrevious(char c) {
        int num =Character.getNumericValue(c);
        if (num == 0) return 9;
        num--;
        return num;
    }

    private static String flipNext(String number, int pos) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            if (i == pos) {
                sb.append(getNext(number.charAt(i)));
            } else {
                sb.append(number.charAt(i));
            }
        }
        return sb.toString();
    }

    private static int getNext(char c) {
        int num =Character.getNumericValue(c);
        if (num == 9) return 0;
        num++;
        return num;
    }

    public static void main(String[] args) {
        System.out.println(openLock(new String[]{"0201","0101","0102","1212","2002"},"0202"));
    }


}
