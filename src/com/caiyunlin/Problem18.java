package com.caiyunlin;

import java.util.ArrayList;
import java.util.Arrays;
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

    //参考三数之和， 循环两次，最后是两两逼近
    private List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {  // 跳过可能重复的答案
                    int l = j + 1, r = nums.length - 1, sum = target - nums[i] - nums[j];
                    while (l < r) {
                        if (nums[l] + nums[r] == sum) {
                            result.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                            while (l < r && nums[l] == nums[l + 1]) l++;
                            while (l < r && nums[r] == nums[r - 1]) r--;
                            l++;
                            r--;
                        } else if (nums[l] + nums[r] < sum) {
                            while (l < r && nums[l] == nums[l + 1]) l++;   // 跳过重复值
                            l++;
                        } else {
                            while (l < r && nums[r] == nums[r - 1]) r--;
                            r--;
                        }
                    }
                }
            }

        }
        return result;
    }


}
