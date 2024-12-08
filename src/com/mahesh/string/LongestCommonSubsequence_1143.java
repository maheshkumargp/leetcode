package com.mahesh.string;

public class LongestCommonSubsequence_1143 {

    public static int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        return matchString(text1, text2, text1.length() - 1, text2.length() - 1, dp);

    }

    private static int matchString(String text1, String text2, int i, int j, int[][] dp) {
        if (i < 0 || j < 0) return 0;
        if (dp[i][j] != 0) return dp[i][j];
        if (text1.charAt(i) == text2.charAt(j)) {
            int temp = 1 + matchString(text1, text2, i - 1, j - 1, dp);
            dp[i][j] = temp;
            return temp;
        }
        return Math.max(matchString(text1, text2, i - 1, j, dp), matchString(text1, text2, i, j - 1, dp));
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde","ace"));
    }

}
