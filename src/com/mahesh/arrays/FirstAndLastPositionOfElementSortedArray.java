package com.mahesh.arrays;

public class FirstAndLastPositionOfElementSortedArray {

   public static int[] searchRange(int[] nums, int target){
       int min = -1, max =-1;
       int left =0,right = nums.length;
       int mid = -1;
       while(left<right){
           mid = (left+right)/2;
           if(nums[mid] == target){
               min = mid;
               right =mid;
           }
           else if(nums[mid] > target){

               right =mid;
           }else{
               left =mid +1;
           }
       }
       left =0;
       right = nums.length;
       mid =-1;
       while(left<right){
           mid = (left+right)/2;
           if(nums[mid] == target){
               max = mid;
               left =mid+1;
           }
           else if(nums[mid] > target){

               right =mid;
           }else{
               left =mid +1;
           }
       }
       int[] result = {min, max};
       return result;
   }

    public static void main(String[] args) {
        //int[] ints = searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        int[] ints = searchRange(new int[]{}, 6);
        System.out.println("{"+ints[0]+" , "+ints[1] + " }");
    }
}
