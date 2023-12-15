package com.mahesh.dp;

public class MinCostClimbingTrees {
    public static int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 2] + cost[i], dp[i - 1]+cost[i]);
        }
        return Math.min(dp[cost.length - 1],dp[cost.length-2]);
    }

    public static void main(String[] args) {
         // int[] x=new int[]{10,15,20};
        int[] x = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(minCostClimbingStairs(x));
        ;

    }
}
