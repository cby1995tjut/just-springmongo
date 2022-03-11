package com.myspringmongo.mymongo.algorithm.leetcode;

public class SearchInsert {

    public static void main(String[] args) {
        int i = binarySearch(new int[]{1}, 1);
    }

    private static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        if (target > nums[right]) {
            return right + 1;
        }
        if (target <= nums[left]) {
            return 0;
        }

        while (true) {
            if ((right - left) <=1 ) {
                return left + 1;
            }
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target){
                left = mid;
            } else {
                return mid;
            }
        }
    }

}
