package com.mahesh.arrays;

import java.util.*;

public class ThreeSum {

    public static void twoSum(int[] nums, int target, int index, Set<List<Integer>> set, List<List<Integer>> result) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> found ;
        for (int i = index+1; i < nums.length; i++) {
            //if (i == index) continue;
            if (map.containsKey(target - nums[i])) {
                found= new ArrayList<>();
                found.add(nums[map.get(target - nums[i])]);
                found.add(nums[i]);
                found.add(nums[index]);
                Collections.sort(found);
                if (!set.contains(found)) {
                   result.add(found);
                    set.add(found);


                }
            }
            map.put(nums[i], i);
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            twoSum(nums, -nums[i], i,set,result);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4,-2,-3,3,0,4}));
    }
}
