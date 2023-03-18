package com.mahesh.string;

public class ReverseString {
    public static void main(String[] args) {
       // char[] s=new char[]{'H','a','n','n','a','h'};
        char[] s=new char[]{'H','e','l','l','o'};
        reverseString(s);
        for (char si:s) {
            System.out.println(" "+si);
        }

    }

    public static void reverseString(char[] s) {
        int j= s.length-1;
        char temp;
for(int i=0;i<s.length/2;i++){
    temp=s[i];
    s[i]=s[j];
    s[j]=temp;
    j--;
}

    }
}
