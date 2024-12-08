package com.mahesh.arrays;

import java.util.ArrayList;
import java.util.HashMap;

public class ShortestDistanceToTargetString_2515 {

    public static void main(String[] args) {
        System.out.println(closetTarget(new String[]{"hello", "i", "am", "leetcode", "hello"}, "hello", 1));
    }

    public static int closetTarget(String[] words, String target, int startIndex) {
        HashMap<String, ArrayList<Integer>> targetMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            final int finalI = i;
            targetMap.compute(words[i], (key, value) -> {
                if (value == null) {
                    value = new ArrayList<>();
                }
                value.add(finalI);
                return value;
            });
        }
        ArrayList<Integer> targets = targetMap.get(target);
        if (targets != null) {
            int min = Integer.MAX_VALUE;

            for (int i : targets) {
                int localMin = Math.min((startIndex - i + words.length) % words.length,
                        (i - startIndex + words.length) % words.length);
                min = Math.min(localMin, min);
            }
            return min;
        }
        return -1;
    }
}
