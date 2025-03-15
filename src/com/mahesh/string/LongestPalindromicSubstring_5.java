package com.mahesh.string;

import java.util.List;

public class LongestPalindromicSubstring_5 {
    public static List<Integer> expandFromCenter(String s, int left,
                                                 int right) {
        // int count = 0;
       // boolean isPalindrome = false;
        // As we expand from the center and find if the
        // character matches, we increase the count.
        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {
            //  count++;
            left--;
            right++;
          //  isPalindrome = true;
        }
      //  if (isPalindrome) {
            return List.of(left + 1, right - 1);
      //  }
      //  return null;
    }

    public static String longestPalindrome(String s) {
        int max = 0;
        String longest = "";
        if(s.length()==1) return s;
        for (int i = 0; i < s.length(); i++) {

            // Taking every node as a center and expanding
            // it from there to check if it is a palindrome
            // or not. This will make sure that the length of
            // the string to be checked > 2.
            List<Integer> list = expandFromCenter(s, i - 1, i + 1);
           // if (list != null) {
                Integer right = list.get(1);
                Integer left = list.get(0);
                if (left >= 0 && right < s.length() && (right - left+1 > max)) {
                    max = right - left;
                    longest = s.substring(left, right+1);
                }
           // }
            list = expandFromCenter(s, i, i + 1);
           // if (list != null) {
                 right = list.get(1);
                 left = list.get(0);
                if (left >= 0 && right < s.length() && (right - left+1 > max)) {
                    max = right - left;
                    longest = s.substring(left, right+1);
                }
            }
       // }
        return longest;

    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("ac"));
    }
}
