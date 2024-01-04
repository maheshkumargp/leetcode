package com.mahesh.arrays;

public class LongestSubStringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        int start = 0, end = 0;
        int global = 0;
        int local = 0;
        while (end < s.length()) {
            if (!s.substring(start, end).contains(s.substring(end, end + 1))) {
                end++;
                local++;
            } else {
                start++;
                local--;
            }
            global = Math.max(global, local);
        }
        return global;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

}
