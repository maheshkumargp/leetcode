package com.mahesh.dp;

public class NthTribonacciNumber {

//    public static int tribonacci(int n) {
//        int zero=0;
//        int one = 1;
//        int two=1;
//        for(int i=3;i<n;i++){
//            if(i%2==0){
//                two=one+two+i;
//            }else{
//                one=one+two+i;
//            }
//
//        }
//        return n%2==0?one:two;
//
//    }

    public static void main(String[] args) {
        System.out.println(tribonacci(25));
    }

    private static int tribonacci(int n) {

        int zero=0;
        int one = 1;
        int two=1;
        for(int i=3;i<=n;i++){
            switch (i%3){
                case 0:
                    zero=zero+one+two;break;
                case 1:
                    one=zero+one+two;break;
                case 2:
                    two=zero+one+two;break;
            }
        }
        return Math.max(Math.max(zero,one),two);
    }
}
