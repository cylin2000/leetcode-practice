package com.caiyunlin;

import java.util.Arrays;

public class Problem16 implements Problem {
    /*
    给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
    例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
    与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
    */
    @Override
    public void Run() {
        int[] nums = new int[]{-1, 2, 1, -4};
        int target = 1;
        int result = threeSumClosest(nums, target);
        System.out.println("result is " + result);
        nums = new int[]{0, 2, 1, -3};
        target = 1;
        result = threeSumClosest(nums, target);
        System.out.println("result is " + result);
    }

    private int threeSumClosest(int[] nums, int target) {
        if (nums.length <= 2) return 0;
        Arrays.sort(nums);
        int tempSum = nums[0] + nums[1] + nums[nums.length - 1];
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(sum - target) < Math.abs(tempSum - target)) {
                    tempSum = sum;
                }
                if (target - sum <= 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return tempSum;
    }
}
