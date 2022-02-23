package com.myspringmongo.mymongo.algorithm.leetcode;


import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

//给你一个字符串 s ，根据下述规则反转字符串：
//
//所有非英文字母保留在原有位置。
//所有英文字母（小写或大写）位置反转。
//返回反转后的 s 。
public class ReverseOnlyLetters {

    public static void main(String[] args) {

        System.out.println(reverseOnlyLetters("a-bC-dEf-ghIj"));
    }

    public static String reverseOnlyLetters(String s) {
        char[] chars = s.toCharArray();
        int right = chars.length - 1;
        for (int i = 0; i < right; i++) {
            if (!Character.isLetter(chars[i])) {
                continue;
            }

            if (!Character.isLetter(chars[right])) {
                i--;
                right--;
                continue;
            }
            char temp = chars[i];
            chars[i] = chars[right];
            chars[right] = temp;
            right--;

        }
        return new String(chars);
    }

    private static boolean isLetters(char c) {
        return ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'));
    }
}
