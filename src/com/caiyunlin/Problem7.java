package com.caiyunlin;

public class Problem7 implements Problem {

    /* 整数反转
    给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
    示例 1:
    输入: 123
    输出: 321
     示例 2:
    输入: -123
    输出: -321
    示例 3:
    输入: 120
    输出: 21
    */

    @Override
    public void Run() {
        int input, result;
        input = 123;
        result = reverse(input);
        System.out.println(input + "reverse is " + result);
        input = -123;
        result = reverse(input);
        System.out.println(input + "reverse is " + result);
        input = 120;
        result = reverse(input);
        System.out.println(input + "reverse is " + result);

        System.out.println("Max Interger is " + Integer.MAX_VALUE);
    }

    //解法：取出符号，然后倒叙，最后用try catch防止溢出
    private int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        //取出符号
        int sign = x > 0 ? 1 : -1;
        String xString = Math.abs(x) + "";
        StringBuilder result = new StringBuilder();
        for (int i = xString.length() - 1; i >= 0; i--) {
            if (xString.charAt(i) != '0' || !result.toString().equals("")) {
                result.append(xString.charAt(i));
            }
        }
        int intResult = 0;
        try {
            intResult = Integer.parseInt(result.toString()) * sign;
        } catch (Exception ex) {
            //do nothing
        }
        return intResult;
    }

    //官方解法 牛B MAX_VALUE : 2147483647 MIN_VALUE : -2147483648
    public int reverse2(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
