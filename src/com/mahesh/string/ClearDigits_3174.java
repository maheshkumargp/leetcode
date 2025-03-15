package com.mahesh.string;

public class ClearDigits_3174 {

    public static String clearDigits(String s) {
        int counter=0;
        StringBuilder result= new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                counter++;
            } else {
               if(counter>0){
                   counter--;
               }else{
                   result.insert(0, ch);
               }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(clearDigits("chg1"));
        System.out.println(clearDigits("cb34"));
        System.out.println(clearDigits("abc"));
    }

}
