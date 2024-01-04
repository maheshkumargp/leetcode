package com.mahesh.dp;

public class MinTimeToMakeRopeColorful1578 {

    public static int minCost(String colors, int[] neededTime) {
        int n= colors.length();
        int i=0;
        int minCost =0;
        while( i<n-1){
            int j=i+1;

                if(colors.charAt(i)==colors.charAt(j)){
                    if(neededTime[i]>neededTime[j]){
                        int temp=neededTime[i];
                        neededTime[i]=neededTime[j];
                        neededTime[j]=temp;
                    }
                   minCost = Math.min(minCost+neededTime[i],minCost+neededTime[j]);
                }

            i++;
        }

        return minCost;
    }

    public static void main(String[] args) {
        System.out.println(minCost("aaabbbabbbb", new int[]{3,5,10,7,5,3,5,5,4,8,1}));
        System.out.println(minCost("abaac", new int[]{1, 2, 3, 4, 5}));
        System.out.println(minCost("abc", new int[]{1, 2, 3}));
    }
}
