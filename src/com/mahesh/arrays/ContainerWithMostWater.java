package com.mahesh.arrays;

public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int l=0,r=height.length-1;
        int globalArea = 0;
        int localArea = 0;
        while(l<r){
            localArea = Math.min(height[l],height[r])*(r-l);
            globalArea = Math.max(localArea,globalArea);
            if(height[l]<height[r]){
                l++;
            }else{
                r--;
            }

        }
return globalArea;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
