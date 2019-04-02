package com.caiyunlin;

public class Problem14 implements Problem {
    /* 最长公众前缀
    编写一个函数来查找字符串数组中的最长公共前缀。
    如果不存在公共前缀，返回空字符串 ""。

    示例 1:
    输入: ["flower","flow","flight"]
    输出: "fl"

    示例 2:
    输入: ["dog","racecar","car"]
    输出: ""
    解释: 输入不存在公共前缀。
    说明:
    所有输入只包含小写字母 a-z
    */

    @Override
    public void Run() {
        String[] input = new String[]{"flower", "flow", "flight"};
        System.out.println("Max prefix of \"flower\", \"flow\", \"flight\" is " + longestCommonPrefix(input));

        input = new String[]{"dog", "racecar", "car"};
        System.out.println("Max prefix of \"dog\", \"racecar\", \"car\" is " + longestCommonPrefix(input));
    }

    private String longestCommonPrefix(String[] strs) {
        //1. 获取最短长度
        int minLength = -1;
        for (String s : strs) {
            if (minLength == -1 || s.length() < minLength) {
                minLength = s.length();
            }
        }
        int left = 0;
        StringBuilder prefix = new StringBuilder();
        while (left < minLength) {
            char tempPrefix = strs[0].charAt(left);
            for (String s : strs) {
                if (tempPrefix != s.charAt(left)) {
                    //中断
                    left = minLength;
                    break;
                }
            }
            if (left < minLength) {
                prefix.append(tempPrefix);
                left++;
            }
        }
        return prefix.toString();
    }


}
