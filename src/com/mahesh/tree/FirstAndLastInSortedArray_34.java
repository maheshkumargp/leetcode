package com.mahesh.tree;

import java.util.Arrays;

public class FirstAndLastInSortedArray_34 {
    static int first = -1;
    static int last = -1;

    public static int[] searchRange(int[] nums, int target) {
        if (nums != null && nums.length > 0)
            search(nums, target, 0, nums.length - 1);
        if(first>-1 && last==-1) last=first;
        if(last>=-1 && first==-1)first=last;
        return new int[]{first, last};
    }

    private static void search(int[] nums, int target, int low, int high) {

        if (low > high) return;
        int mid = (low + high) / 2;
        if ((nums[mid] == target && mid > 0 && nums[mid - 1] < target)
                || (nums[mid] == target && mid == 0)) {
            first = mid;
            search(nums, target, mid + 1, high);
            //low = mid + 1;
        } else if ((nums[mid] == target && mid < nums.length - 1 && nums[mid + 1] > target)
                || (nums[mid] == target && mid == nums.length - 1)) {
            last = mid;
            search(nums, target, low, mid - 1);
            // high = mid - 1;
        } else if (nums[mid] == target) {
            search(nums, target, mid + 1, high);
            search(nums, target, low, mid - 1);
        } else if (nums[mid] > target) {
            search(nums, target, low, mid - 1);
        } else {
            search(nums, target, mid + 1, high);
        }


    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int[] nums1 = new int[]{1};
        Arrays.stream(searchRange(nums1, 1)).forEach(System.out::println);
        Arrays.stream(searchRange(nums, 8)).forEach(System.out::println);
        //System.out.println(searchRange(nums,8));
    }
}
