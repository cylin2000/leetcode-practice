package com.caiyunlin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem17 implements Problem {

    /*
        https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
        17. 电话号码的字母组合
        给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
        给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
        示例:
        输入："23"
        输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
        说明:
        尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
    */

    @Override
    public void Run() {
        String digits = "9";
        List<String> result = letterCombinations(digits);
        System.out.println(result);
    }

    private List<String> letterCombinations(String digits) {
        HashMap<Character, String[]> map = new HashMap<>();
        map.put('2', new String[]{"a", "b", "c"});
        map.put('3', new String[]{"d", "e", "f"});
        map.put('4', new String[]{"g", "h", "i"});
        map.put('5', new String[]{"j", "k", "l"});
        map.put('6', new String[]{"m", "n", "o"});
        map.put('7', new String[]{"p", "q", "r", "s"});
        map.put('8', new String[]{"t", "u", "v"});
        map.put('9', new String[]{"w", "x", "y", "z"});
        List<String> result = new ArrayList<>();
        for (Character c : digits.toCharArray()) {
            if (map.containsKey(c)) {
                result = getCombinations(map.get(c), result);
            }
        }
        return result;
    }

    private List<String> getCombinations(String[] chars, List<String> listString) {
        List<String> result = new ArrayList<>();
        if (listString.isEmpty()) {
            for (String c : chars) {
                result.add(c);
            }
        } else {
            for (String s : listString) {
                for (String c : chars) {
                    result.add(s + c);
                }
            }
        }
        return result;
    }
}
