package com.mahesh.dp;

import java.util.Arrays;

public class HouseRobber {

    public static int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n ];
        Arrays.fill(dp, -1);
        return rob(nums, n - 1, dp);
    }

    private static int rob(int[] nums, int n, int[] dp) {

        if (n == 0) return nums[0];
        if (n == 1) return Math.max(nums[0],nums[1]);
        if (dp[n] != -1) return dp[n];
        dp[n] = Math.max(nums[n] + rob(nums, n - 2, dp), rob(nums, n - 1, dp));
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{2, 1, 1, 2}));
        System.out.println(rob(new int[]{2, 7, 9, 3, 1}));
    }

}
