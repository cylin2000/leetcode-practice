package com.caiyunlin;

public class Problem11 implements Problem {
    /*
     盛最多水的容器
     给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
    说明：你不能倾斜容器，且 n 的值至少为 2。
    https://leetcode-cn.com/problems/container-with-most-water/

    输入: [1,8,6,2,5,4,8,3,7]
    输出: 49

    */

    @Override
    public void Run() {
        int[] input = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int result = maxArea2(input);
        System.out.println("result is " + result);
    }

    //暴力解法 O(n^2) 循环两次
    private int maxArea(int[] height) {
        int area = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int tempArea = (j - i) * Math.min(height[i], height[j]);
                if (tempArea > area) {
                    area = tempArea;
                }
            }
        }
        return area;
    }

    //官方解法 O(n) 循环一次
    private int maxArea2(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxarea;
    }
}
