package com.myspringmongo.mymongo.algorithm.leetcode;

//给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
//
//        回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
//
//        例如，121 是回文，而 123 不是。

import java.util.ArrayList;
import java.util.List;

public class Palindrome {

    public static void main(String[] args) {

    }

    private static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        List<Integer> tempList = new ArrayList<>();
        int a = x;
        while (a >= 10) {
          tempList.add(a % 10);
          a = a / 10;
        }
        tempList.add(a);
        for (int i = 0; i < tempList.size() / 2; i++) {
            if (tempList.get(i) != tempList.get(tempList.size() - 1 - i)) {
                return false;
            }
        }
        return true;

    }

    //todo improve
}
