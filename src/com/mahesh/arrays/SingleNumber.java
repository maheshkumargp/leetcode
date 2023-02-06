package com.mahesh.arrays;

import java.util.HashSet;

public class SingleNumber {
    public static void main(String[] args) {
        System.out.println("Result : " + singleNumber(new int[]{2, 2, 1}));
        System.out.println("Result : " + singleNumber(new int[]{4, 1, 2, 1, 2}));
        System.out.println("Result : " + singleNumber(new int[]{1}));

    }

    public static int singleNumber(int[] nums) {
        HashSet<Integer> numbers = new HashSet<>();
        for (int i : nums) {
            if (numbers.contains(i)) numbers.remove(i);
            else numbers.add(i);
        }
        return numbers.stream().findFirst().get();
    }
}
