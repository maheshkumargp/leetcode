package com.mahesh.arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {

        //int[] i = twoSum(new int[]{2, 7, 11, 15}, 9);
        int[] i = twoSum(new int[]{3,2,4}, 6);
        System.out.println("result "+ i[0]+i[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i< nums.length;i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }

}
