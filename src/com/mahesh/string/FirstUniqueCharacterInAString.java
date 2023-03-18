package com.mahesh.string;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqueCharacterInAString {
    public static void main(String[] args) {
        System.out.println(" result : "+firstUniqChar("leetcode"));
        System.out.println(" result : "+firstUniqChar("loveleetcode"));
        System.out.println(" result : "+firstUniqChar("aabb"));

    }

    public static  int firstUniqChar(String s) {
        LinkedHashMap<Character,Integer> linkedHashMap= new LinkedHashMap<>();
for(int i=0;i<s.length();i++){
  Character x=  s.charAt(i);

    if(linkedHashMap.containsKey(x)){
        linkedHashMap.put(x,-1);
    }else{
                linkedHashMap.put(x,i);
    }

}
        return linkedHashMap.entrySet().stream().filter(x->x.getValue()!=-1).findFirst().map(Map.Entry::getValue).orElse(-1);
    }
}
