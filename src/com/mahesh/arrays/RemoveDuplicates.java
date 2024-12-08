package com.mahesh.arrays;

import java.util.Arrays;

public class RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 1;
        while (j < nums.length) {
            if (nums[i] == nums[j]) {
                //i++;
                j++;
            } else {
                i++;
                nums[i]=nums[j];
            }
        }

        return i+1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 4, 4, 4};
        int[] nums1 = {1, 1, 2};
        int[] nums2 = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums2));
        System.out.println(Arrays.toString(nums2));
    }

}
