package com.mahesh.arrays;

public class BestTimeToBuyAndSellStock2 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{3,2,6,5,0,3}));
    }

    public static int maxProfit(int[] prices) {
        int buy=0;
        boolean buyFlag=false;
        int total=0;
        int j=0;
        for(int i=1;i<prices.length;i++){
            if(prices[j]<prices[i]){
                if(!buyFlag){
                    buy=j;
                    buyFlag=true;
                }
            }else{
                if(buyFlag) {
                    total = total + prices[j] - prices[buy];
                    buyFlag = false;
                }
            }
            j++;

        }
        if(buyFlag){
            if(prices[buy]<prices[prices.length-1]){
                total=total+prices[prices.length-1]-prices[buy];
            }
        }
        return Math.max(total, 0);

    }
}
