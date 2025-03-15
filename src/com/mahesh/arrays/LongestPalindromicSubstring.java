package com.mahesh.arrays;

public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            result=result +s.charAt(i);
            String odd = expandFromCenter(s, s.length(), i - 1, i + 1);
            String even = expandFromCenter(s, s.length(), i, i + 1);
            if (odd.length() > even.length()) {
                if (odd.length() > result.length())
                    result = odd;

            } else {
                if (even.length() > result.length())
                    result = even;
            }
        }
        return result;
    }

    private static String expandFromCenter(String s, int n, int j, int k) {
        String result="";
        while (j >= 0 && k < n && s.charAt(j) == s.charAt(k)) {
            result=s.substring(j,k+1);
            j--;
            k++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("racecar"));
        // System.out.println(countPalindromicSubstrings("racecar"));
        // System.out.println(countPalindromes("racecar"));
    }
}
