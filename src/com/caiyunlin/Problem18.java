package com.caiyunlin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem18 implements Problem {
    /*
    四数之和
    给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
    注意：
    答案中不可以包含重复的四元组。
    示例：
    给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
    满足要求的四元组集合为：
    [
      [-1,  0, 0, 1],
      [-2, -1, 1, 2],
      [-2,  0, 0, 2]
    ]
    */

    @Override
    public void Run() {
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        int target = 0;
        List<List<Integer>> result = fourSum(nums, target);
        System.out.println(result);
    }

    private List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                for (int k = j + 1; k < nums.length - 1; k++) {
                    for (int l = k + 1; l < nums.length; l++) {
                        if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
                            List<Integer> temp = new ArrayList<>();
                            temp.add(nums[i]);
                            temp.add(nums[j]);
                            temp.add(nums[k]);
                            temp.add(nums[l]);
                            if (!isDuplicate(result, temp)) {
                                result.add(temp);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    private boolean isDuplicate(List<List<Integer>> results, List<Integer> temp) {
        Collections.sort(temp);
        for (List<Integer> arr : results) {
            Collections.sort(arr);
            if (temp.get(0).equals(arr.get(0)) && temp.get(1).equals(arr.get(1)) && temp.get(2).equals(arr.get(2)) && temp.get(3).equals(arr.get(3))) {
                return true;
            }
        }
        return false;
    }

}
