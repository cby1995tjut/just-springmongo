package com.myspringmongo.mymongo.algorithm.leetcode;
//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
//有效字符串需满足：
//
//左括号必须用相同类型的右括号闭合。
//左括号必须以正确的顺序闭合。

import scala.Char;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ValidBracketsString {
    //规律，一个字符肯定是和i + 1 * n位置的字符闭合
    public static void main(String[] args) {
        String s = "()[]{}";
        boolean valid = isValid("[({])}");
    }

    //todo improve, test case passed 84/91
    public static boolean isValid(String s) {
        if (s == null || s.trim().isEmpty()) {
            return true;
        }
        int length = s.length();
        if (length % 2 == 1) {
            return false;
        }
        List<Integer> indexes = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            int temp = i + 1;
            char left = s.charAt(i);
            int size = indexes.size();
            boolean flag = false;
            while (temp < length && !indexes.contains(i)) {
                flag = true;
                if (equals(left, s.charAt(temp))) {
                    indexes.add(temp);
                    break;
                }

                temp = temp + 2;
            }

            if (indexes.size() == size && flag) {
                return false;
            }
        }
        return true;
    }

    private static boolean equals(char left, char right) {
        if (left == '(' && right == ')') {
            return true;
        }
        if (left == '[' && right == ']') {
            return true;
        }
        if (left == '{' && right == '}') {
            return true;
        }
        return false;
    }


}
