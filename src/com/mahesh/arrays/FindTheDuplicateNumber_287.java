package com.mahesh.arrays;

public class FindTheDuplicateNumber_287 {

    public static int findDuplicate(int[] nums) {

        int sum =0;
        int max =0;

        for(int i=0;i<nums.length;i++){
            sum = sum +nums[i];
            max = Math.max(max,nums[i]);
        }

        return sum - (max * (max+1)/2);
    }

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{1,3,4,2,2}));
        System.out.println(findDuplicate(new int[]{3,1,3,4,2}));
        System.out.println(findDuplicate(new int[]{3,3,3,3,3}));
    }

}
