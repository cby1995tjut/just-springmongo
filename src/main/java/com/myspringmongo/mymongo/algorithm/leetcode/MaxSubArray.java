package com.myspringmongo.mymongo.algorithm.leetcode;

public class MaxSubArray {

    public static void main(String[] args) {
        int i = maxSubArray(new int[] {-1,-2, 4, 1, 2});
        System.out.println(i);
    }

    public static int maxSubArray(int[] nums) {
        int sum = 0;
        int result = nums[0];
        for (int i: nums) {
            //如果sum > 0, 那么对后续子序列有益, sum是上一次计算结果
            if (sum > 0) {
                sum = sum + i;
            } else {
                sum = i;
            }

            result = Math.max(result, sum);
        }

        return result;
    }
}
