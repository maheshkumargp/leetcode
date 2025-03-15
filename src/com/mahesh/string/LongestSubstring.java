package com.mahesh.string;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LongestSubstring {

    static List<String> repeatedStrings(String s) {
        HashMap<String, Integer> frequency = new HashMap<>();
        for (int i = 0; i < s.length() / 2; i++) {
            int winLength = i + 1;
            int start = 0;
            int end = 1;

            while (end <= s.length()) {
                if ((end - start) < winLength) {
                    end++;
                } else {

                    String temp = s.substring(start, end);
                    frequency.compute(temp, (key, val) ->
                            val == null ? 1 : val + 1
                    );
                    start++;
                    end++;
                }

            }

        }

        return frequency.entrySet().stream()
                .filter(stringIntegerEntry -> stringIntegerEntry.getValue() > 1)
                .map(Map.Entry::getKey).collect(Collectors.toList());


    }


    public static void main(String[] args) {
        System.out.println(repeatedStrings("abcabcabc"));
    }

}
