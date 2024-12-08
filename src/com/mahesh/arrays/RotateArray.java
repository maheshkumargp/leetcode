package com.mahesh.arrays;

public class RotateArray {

    private static void reverse(int[] nums, int i, int n) {
        while (i < n) {
            int temp = nums[i];
            nums[i] = nums[n];
            nums[n] = temp;
            i++;
            n--;
        }
    }

    public static void rotate(int[] nums, int k) {
        
        int i = 0;
        int n = nums.length - 1;
        reverse(nums, i, n);
        i = 0;
        n = k - 1;
        reverse(nums, i, n);
        i = k ;
        n = nums.length - 1;
        reverse(nums, i, n);
    }

    public static void rotate1(int[] nums, int k){
        for(int i=nums.length-1;i>k;i--){
            int temp = nums[i];
            nums[i] = nums[i-k];
            nums[i-k] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        rotate1(nums,3);
        for (int num : nums) System.out.print(num + ", ");
    }
}
