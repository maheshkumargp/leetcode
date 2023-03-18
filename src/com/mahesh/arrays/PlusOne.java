package com.mahesh.arrays;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{1, 2, 3})));
    }

    public static int[] plusOne(int[] digits) {
        int[] result = new int[digits.length + 1];
        int carry = 0;
        if (digits[digits.length - 1] + 1 > 9) {
            result[result.length - 1] = 0;
            carry = 1;
        } else {
            result[result.length - 1] = digits[digits.length - 1] + 1;
        }
        for (int i = digits.length - 2; i >= 0; i--) {
            if (carry == 1) {
                if (digits[i] + 1 > 9) {
                    result[i + 1] = 0;
                    carry = 1;
                } else {
                    result[i + 1] = digits[i] + 1;
                    carry = 0;
                }

            } else {
                result[i + 1] = digits[i];
                carry = 0;
            }
        }
        if (carry == 1) result[0] = 1;
        else result[0] = 0;
        return result;
    }
}
