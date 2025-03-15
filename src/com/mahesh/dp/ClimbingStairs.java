package com.mahesh.dp;

public class ClimbingStairs {


    public static int climbStairs(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = -1;
        }
        return climbStairs(n, dp);

    }

    private static int climbStairs(int n, int[] dp) {
        if (n == 0) return 1;
        if (n < 0) return 0;
        if (dp[n] != -1) return dp[n];
        dp[n] = climbStairs(n - 1, dp) + climbStairs(n - 2, dp);
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }


}
