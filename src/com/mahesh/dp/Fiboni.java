package com.mahesh.dp;

public class Fiboni {

  // static int[] dp = new int[100];
    public static void main(String[] args) {
        System.out.println(fib(146));

    }

    static int fib(int n){
        if(n<=2) return 1;
       // if(dp[n]!=0) return dp[n];
        int i = fib(n - 1) + fib(n - 2);
       // dp[n]=i;
        return i;
    }
}
