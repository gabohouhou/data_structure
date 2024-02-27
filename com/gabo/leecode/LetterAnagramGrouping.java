package com.gabo.leecode;

import java.util.*;

/**
 * @Description: 49. 字母异位词分组 mid
 * @Author: gabo
 * @Date: 2024/02/20 22:27
 **/
public class LetterAnagramGrouping {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null) {
            return new ArrayList<>();
        }
        Map<String,Integer> map = new HashMap<>();
        List<List<String>> resList = new ArrayList<>();
        for (int i=0;i<strs.length;i++) {
            String str = strs[i];
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            if (map.containsKey(chars.toString())) {
                for (List<String> list : resList) {
                    String s = list.get(0);
                    char[] chars1 = s.toCharArray();
                    Arrays.sort(chars1);
                    if (chars1.equals(chars)) {
                        list.add(strs[i]);
                        break;
                    }
                }
                continue;
            }
            List<String> list = new ArrayList<>();
            list.add(strs[i]);
            map.put(chars.toString(),0);
            resList.add(list);
        }
        return null;
    }
}
