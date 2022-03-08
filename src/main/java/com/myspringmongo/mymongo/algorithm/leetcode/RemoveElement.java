package com.myspringmongo.mymongo.algorithm.leetcode;

import java.util.Arrays;

public class RemoveElement {


    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6};
    }

    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = nums.length;

//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == val) {
//                result--;
//                nums[i] = nums[i + 1];
//                nums[i + 1] = 0
//                i--;
//            }
//        }

        return result;
    }

}
