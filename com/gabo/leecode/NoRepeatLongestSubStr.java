package com.gabo.leecode;

import java.util.HashMap;

/**
 * 03.不重复的最长子串字符串 mid
 * @Author gaboness
 * @Date 2024/02/27 16:46:00
 */
public class NoRepeatLongestSubStr {

    public static void main(String[] args) {
        String input = "abcabcbbabcfe";
        System.out.println("The length of the longest substring without repeating characters is: " +
                lengthOfLongestSubstring(input));

    }

    public static int lengthOfLongestSubstring(String s) {
        // 使用HashMap来存储字符及其在字符串中最新的位置
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 0; // 用来记录最长子串的长度
        int left = 0; // 滑动窗口的左边界

        // 遍历字符串
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            // 当发现重复字符时，更新左边界。left 取当前left和上一次出现该字符位置加一的较大值
            if (map.containsKey(currentChar)) {
                left = Math.max(left, map.get(currentChar) + 1);
            }
            // 不管是否更新了left，都要更新当前字符的位置
            map.put(currentChar, right);
            // 计算当前窗口的长度，更新最大长度
            maxLength = Math.max(maxLength, right - left + 1);
        }

        // 返回找到的最大长度
        return maxLength;
    }
}
