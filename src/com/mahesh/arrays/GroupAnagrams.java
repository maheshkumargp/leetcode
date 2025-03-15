package com.mahesh.arrays;

import java.util.*;

public class GroupAnagrams {


    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<List<Integer>,List<String>> result = new HashMap<>();
        Arrays.stream(strs).forEach(str ->{
            List<Integer> temp = new ArrayList<>(Collections.nCopies(26, 0));
            for(int i=0;i<str.length();i++){
                int index = str.charAt(i) - 'a';
                temp.set(index, temp.get(index)+1);
            }
            result.computeIfAbsent(temp,k->new ArrayList<>()).add(str);
        });

       return new ArrayList<>(result.values());

    }

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }

}
