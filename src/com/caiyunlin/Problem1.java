package com.caiyunlin;

import java.util.HashMap;

public class Problem1 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] results = twoSum(nums, target);
        System.out.println("Index is " + results[0] + " and " + results[1]);
        results = twoSum2(nums, target);
        System.out.println("Index is " + results[0] + " and " + results[1]);
    }

    // 解法1：直接循环两次，时间复杂度O(n2)，空间复杂度O(1)
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("Can't Find Result");
    }

    //解法2：使用HashMap
    public static int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
