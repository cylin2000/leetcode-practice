package com.caiyunlin;

public class Problem5 implements Problem {

    /*
    最长回文数：
    给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
    示例 1：
    输入: "babad"
    输出: "bab"
    注意: "aba" 也是一个有效答案。
    示例 2：
    输入: "cbbd"
    输出: "bb"
    */

    @Override
    public void Run() {
        String s = "babad";
        String result = longestPalindrome(s);
        System.out.println("longest palindrome of " + s + " is " + result);

        s = "cbbd";
        result = longestPalindrome(s);
        System.out.println("longest palindrome of " + s + " is " + result);


    }

    private String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        String tempString = "";
        String tempResult = "";
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 2; j < s.length(); j++) {
                tempString = s.substring(i, j);
                if (isPalindrome(tempString)) {
                    if (tempString.length() > 1 && tempString.length() > tempResult.length()) {
                        tempResult = tempString;
                    }
                }
            }
        }
        return tempResult;
    }

    private boolean isPalindrome(String s) {
        boolean result = true;
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - 0)) {
                result = false;
            }
        }
        return result;
    }
}
