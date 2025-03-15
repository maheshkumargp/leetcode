package com.mahesh.string;

import java.util.Arrays;

public class ValidAnagram{
    public static boolean isAnagram(String s, String t) {

        int[] sChar= new int[26];
        int[] tChar = new int[26];

        countChars(s, sChar);
        countChars(t, tChar);

        return Arrays.equals(sChar, tChar);

    }

    private static void countChars(String s, int[] sChar) {
        for(char i : s.toCharArray()){
            sChar[i-'a']++;
        }
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram","nagaram"));
        System.out.println(isAnagram("rat","cat"));
    }
}
