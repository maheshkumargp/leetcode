package com.mahesh.arrays;

import java.util.HashSet;


public class ContainsDuplicate {
    public static void main(String[] args) {
        System.out.println("Result: "+containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2}));
        System.out.println("Result: "+containsDuplicate(new int[]{1,2,3,4}));

    }
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> numbers= new HashSet<>();
        for (int i:nums)
        {
            if(!numbers.add(i)) return true;
        }

return false;
    }
}
