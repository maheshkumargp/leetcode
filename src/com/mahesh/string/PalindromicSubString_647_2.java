package com.mahesh.string;

public class PalindromicSubString_647_2 {
    public static int countSubstrings(String s)
    {
        int count=0;
        for(int i=0;i<s.length();i++){
            count = count+ expandFromCenter(s,s.length(),i-1,i+1)+expandFromCenter(s,s.length(),i,i+1);
        }
        return count + s.length();
    }

    private static int expandFromCenter(String s, int n, int j, int k) {
        int count=0;
        while(j>=0 && k<n && s.charAt(j)==s.charAt(k) ){
           // if(s.charAt(j)==s.charAt(k)){
                count++;
                j--;
                k++;
           // }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("racecar"));
       // System.out.println(countPalindromicSubstrings("racecar"));
       // System.out.println(countPalindromes("racecar"));
    }
}
