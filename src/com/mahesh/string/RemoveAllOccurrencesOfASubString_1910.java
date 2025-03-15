package com.mahesh.string;

public class RemoveAllOccurrencesOfASubString_1910 {

    public static String removeOccurrences(String s, String part) {
        int i = 0;
        int j = 0;
        int winStart = 0;
        boolean match = false;
        StringBuilder result = new StringBuilder();
        int partLength = part.length();
        while (i < s.length()) {

            if (j >= partLength) {
                i = winStart - 1;
                match = true;
                j = 0;
            } else if (s.charAt(i) == part.charAt(j)) {
                if (match) {
                    i = i + partLength;
                    match = false;
                } else {
                    i++;
                }
                j++;
            } else {
                for (int k = j; k >= 0; k--) {
                    result.append(s.charAt(i - k));
                }
                j=0;
                i++;
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeOccurrences("daabcbaabcbc", "abc"));
    }

}
