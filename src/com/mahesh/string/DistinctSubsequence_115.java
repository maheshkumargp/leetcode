package com.mahesh.string;

public class DistinctSubsequence_115 {

    public static int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            dp[i][0] = 1;
        }

        for (int j = 1; j <= t.length(); j++) {
            dp[0][j] = 0;
        }

        return numDistinct(s, t, dp);

    }

    private static int numDistinct(String s, String t,
                                   int[][] dp) {
//        if (j <= 0) return 1;
//        if (i <= 0) return 0;
        // if (dp[i][j] > -1) return dp[i][j];
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
//            dp[i][j] = numDistinct(s, t, i - 1, j - 1, dp) +
//                    numDistinct(s, t, i - 1, j, dp);
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                    // dp[i][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                    //numDistinct(s, t, i - 1, j, dp);
                }
            }
        }
        return dp[s.length()][t.length()];
    }

    public static void main(String[] args) {
        System.out.println(numDistinct("rabbbit", "rabbit"));
        System.out.println(numDistinct("babgbag", "bag"));
    }
}
