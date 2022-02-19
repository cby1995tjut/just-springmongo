package com.myspringmongo.mymongo.algorithm.leetcode;

//示例 1：
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1]
//
//示例 2：
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
//
//示例 3：
//输入：nums = [3,3], target = 6
//输出：[0,1]

//# 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。


public class SumTwoNumbers {
    public static void main(String[] args) {

    }

    //
    public int[] getTargetIndexes(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    //todo resolve by hase map

}