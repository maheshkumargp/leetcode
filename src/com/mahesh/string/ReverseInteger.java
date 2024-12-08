package com.mahesh.string;

public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse(1534236469));

    }

    public static int reverse(int x) {
        String result = "";
        if (x < 0) {
            result = "-";
            x = x * -1;
        }
        while (x / 10 != 0) {
            int mod = x % 10;
            x = x / 10;
            result = result + mod;
        }
        result = result + x;
        try {
            return Integer.parseInt(result);
        } catch (RuntimeException e) {
            return 0;
        }
    }
}
