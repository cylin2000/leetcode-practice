package com.caiyunlin;

import java.util.HashMap;

public class Problem3 implements Problem {
    /*
    给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
    示例 1:
    输入: "abcabcbb"
    输出: 3
    解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
    示例 2:
    输入: "bbbbb"
    输出: 1
    解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
    示例 3:
    输入: "pwwkew"
    输出: 3
    解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
         请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
    */

    @Override
    public void Run() {
        String input;
        int length;
        input = "abcabcbb";
        length = lengthOfLongestSubstring(input);
        System.out.println("length of longest sub string for " + input + " is " + length);

        input = "bbbbb";
        length = lengthOfLongestSubstring(input);
        System.out.println("length of longest sub string for " + input + " is " + length);

        input = "pwwkew";
        length = lengthOfLongestSubstring(input);
        System.out.println("length of longest sub string for " + input + " is " + length);

    }

    //结题，使用HashMap判断之前的字符在不在
    public int lengthOfLongestSubstring(String input) {
        String[] arr = input.split("");
        HashMap<String, String> map = new HashMap<String, String>();
        int maxLength = 0;
        int currentLength = 0;
        for (int i = 0; i < arr.length; i++) {
            currentLength = currentLength + 1;
            if (map.containsKey(arr[i])) {
                currentLength = 1;
            }
            map.put(arr[i], arr[i]);
            if (currentLength > maxLength) {
                maxLength = currentLength;
            }
        }
        return maxLength;
    }
}
