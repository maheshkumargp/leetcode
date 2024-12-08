package com.mahesh.string;

public class PalindromicSubString_647 {

    public static int countSubstrings(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            count++;
            int j = i + 1;
            int k = i - 1;
            while (j < s.length() && k >= 0 && s.charAt(j) == s.charAt(k)) {
                count++;
                j++;
                k--;
            }
        }
        return count;
    }


    public static int countPalindromicSubstrings(String s) {
        int n = s.length();
        int count = 0;
        for (int center = 0; center < 2 * n - 1; center++) {
            int l = center / 2;
            int r = l + center % 2;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                count++;
                l--;
                r++;
            }
        }
        return count;
    }

    public static int countPalindromes(String s)
    {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {

            // Taking every node as a center and expanding
            // it from there to check if it is a palindrome
            // or not. This will make sure that the length of
            // the string to be checked > 2.
            count += expandFromCenter(s, i - 1, i + 1)
                    + expandFromCenter(s, i, i + 1);
        }

        return count;
    }

    public static int expandFromCenter(String s, int left,
                                       int right)
    {
        int count = 0;

        // As we expand from the center and find if the
        // character matches, we increase the count.
        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("racecar"));
        System.out.println(countPalindromicSubstrings("racecar"));
        System.out.println(countPalindromes("racecar"));
    }

}
