package com.caiyunlin;

public class Problem4 implements Problem {
    /*
    给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
    请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
    你可以假设 nums1 和 nums2 不会同时为空。
        示例 1:
        nums1 = [1, 3]
        nums2 = [2]
        则中位数是 2.0
        示例 2:
        nums1 = [1, 2]
        nums2 = [3, 4]
        则中位数是 (2 + 3)/2 = 2.5
    */

    @Override
    public void Run() {
        int[] nums1 = new int[]{1, 3};
        int[] nums2 = new int[]{2};
        double nums3 = findMedianSortedArrays(nums1, nums2);
        System.out.println(nums3);

        nums1 = new int[]{1,2};
        nums2 = new int[]{3,4};
        nums3 = findMedianSortedArrays(nums1, nums2);
        System.out.println(nums3);
    }

    //基本思路，将两个数组循环合并，然后取得中位数
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums3 = new int[nums1.length + nums2.length];
        int i = 0, j = 0, k = 0;
        while (i < nums1.length || j < nums2.length) {
            if(i >= nums1.length){ // 数组1越界
                int y =  nums2[j] ;
                nums3[k] = y;
                j = j + 1;
            }
            else if(j >= nums2.length){ // 数组2越界
                int x =  nums1[i] ;
                nums3[k] = x;
                i = i + 1;
            }
            else{
                int x =  nums1[i] ;
                int y =  nums2[j] ;
                if(x > y){
                    nums3[k] = y;
                    j = j + 1;
                }
                else{
                    nums3[k] = x;
                    i = i + 1;
                }
            }

            k = k + 1;
        }
        if (nums3.length % 2 == 0) {
            return (double)(nums3[(nums3.length / 2) - 1] + nums3[nums3.length / 2]) / 2;
        } else {
            return nums3[(nums3.length - 1) / 2];
        }
    }

    //中位数：https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/
}
