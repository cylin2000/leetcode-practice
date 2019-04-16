package com.caiyunlin;

import java.util.Stack;

public class Problem20 implements Problem {
    /*
    给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

    有效字符串需满足：

    左括号必须用相同类型的右括号闭合。
    左括号必须以正确的顺序闭合。
    注意空字符串可被认为是有效字符串。

    示例 1:

    输入: "()"
    输出: true
    示例 2:

    输入: "()[]{}"
    输出: true
    示例 3:

    输入: "(]"
    输出: false
    示例 4:

    输入: "([)]"
    输出: false
    示例 5:

    输入: "{[]}"
    输出: true
    */

    @Override
    public void Run() {
        String input;
        input = "()";
        System.out.println(input + " is valid ? " + isValid(input));
        input = "()[]{}";
        System.out.println(input + " is valid ? " + isValid(input));
        input = "([";
        System.out.println(input + " is valid ? " + isValid(input));
        input = "([)]";
        System.out.println(input + " is valid ? " + isValid(input));
        input = "{[]}";
        System.out.println(input + " is valid ? " + isValid(input));
    }

    //解题思路，设置一个临时字符串，遍历源字符串，挨个添加到末尾，如果在临时字符串尾部发现对称字符串，则删除之，最后判断临时字符串是否为空
    public boolean isValid(String s) {
        StringBuilder sb = new StringBuilder();
        for (Character c : s.toCharArray()) {
            if (sb.toString().equals("")) {
                sb.append(c.toString());
            } else {
                if (sb.substring(sb.length() - 1, sb.length()).equals(getReverse(c.toString()))) {
                    sb.delete(sb.length() - 1, sb.length());
                } else {
                    sb.append(c.toString());
                }
            }
        }
        return sb.toString().equals("");
    }

    //相反的方向不用计算，也不能返回源字符串，否则 (( 会显示为正确
    private String getReverse(String s) {
        if (s.equals(")")) {
            return "(";
        }
        if (s.equals("]")) {
            return "[";
        }
        if (s.equals("}")) {
            return "{";
        }
        return " ";
    }

    //以下解法比较优雅(用栈)
    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (stack.size() == 0) {
                stack.push(aChar);
            } else if (isSym(stack.peek(), aChar)) {
                stack.pop();
            } else {
                stack.push(aChar);
            }
        }
        return stack.size() == 0;
    }

    private boolean isSym(char c1, char c2) {
        return (c1 == '(' && c2 == ')') || (c1 == '[' && c2 == ']') || (c1 == '{' && c2 == '}');
    }
}
