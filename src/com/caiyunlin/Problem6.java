package com.caiyunlin;

import java.util.ArrayList;
import java.util.List;

public class Problem6 implements Problem {
    /* Z型排列
    将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
    比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
    L   C   I   R
    E T O E S I I G
    E   D   H   N
    之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。

    请你实现这个将字符串进行指定行数变换的函数：

    string convert(string s, int numRows);
    示例 1:

    输入: s = "LEETCODEISHIRING", numRows = 3
    输出: "LCIRETOESIIGEDHN"
    示例 2:

    输入: s = "LEETCODEISHIRING", numRows = 4
    输出: "LDREOEIIECIHNTSG"
    解释:

    L     D     R
    E   O E   I I
    E C   I H   N
    T     S     G
    */

    @Override
    public void Run() {
        String s = "LEETCODEISHIRING";
        int numRows = 3;
        String result = convert(s, numRows);
        System.out.println(s + " convert to " + result);

        s = "LEETCODEISHIRING";
        numRows = 4;
        result = convert(s, numRows);
        System.out.println(s + " convert to " + result);

    }

    // 解题思路，不用考虑太复杂，其实轮训字符串，然后用row表示行数,row的求法就是碰到0后面就增加，碰到最大行数后面就减少
    // 注意使用 StringBuilder 避免字符串拼接，因为字符串拼接效率较低
    // 注意 Java foreach的写法，应该是 for(StringBuilder row : rows){   }
    private String convert(String s, int numRows) {
        if (s == null || s.length() < 1) return "";
        int maxRows = s.length() < numRows ? s.length() : numRows;
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < maxRows; i++) {
            rows.add(new StringBuilder());
        }

        int rowIndex = 0;
        int going = 1;
        for (int i = 0; i < s.length(); i++) {
            rows.get(rowIndex).append(s.charAt(i));
            if (rowIndex == 0) {
                going = 1;
            }
            if (rowIndex == numRows - 1) {
                going = -1;
            }
            rowIndex = rowIndex + going;
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row.toString());
        }
        return result.toString();
    }


}
