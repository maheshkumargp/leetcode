package com.mahesh.other;

public class AlternateGrouping_3208 {

    public static int numberOfAlternatingGroups(int[] colors, int k) {
        int j = 1;
        int i=0;
        int count1=0;
        while(count1<2*colors.length){
            if (colors[i] == colors[j]) break;
            j = (j + 1) % colors.length;
            i = (i + 1) % colors.length;
            count1++;
        }


        int iter = 0;
        int count = 0;
        int window = 0;
        while (iter <= colors.length) {
            int next =  (j + 1) % colors.length;
            if (colors[j] == colors[next]) {
                window = 0;
            } else {
                window++;
                if (window == k - 1) {
                    window = k-2;
                    count++;
                }
            }
            iter++;
            j = (j + 1) % colors.length;
        }
        return count;

    }

    public static void main(String[] args) {
//        System.out.println(numberOfAlternatingGroups(new int[]{0,1,0,1,0},3));
//        System.out.println(numberOfAlternatingGroups(new int[]{0,1,0,0,1,0,1},6));
        System.out.println(numberOfAlternatingGroups(new int[]{0,1,0,1},4));
        System.out.println(numberOfAlternatingGroups(new int[]{0,1,0,1},3));
    }

}
