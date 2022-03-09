package com.myspringmongo.mymongo.algorithm.leetcode;

import java.util.Arrays;

public class RemoveElement {


    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6};
    }

    public static int removeElement(int[] nums, int val) {
        int result = 0;
        //遍历，当当前元素不是val时，就将其放入原数组中
        for (int num: nums) {
            if (num != val) {
                nums[result] = num;
                result++;
            }
        }

        return result;
    }

}
