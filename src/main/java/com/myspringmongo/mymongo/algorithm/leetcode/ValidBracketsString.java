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
import java.util.Stack;

public class ValidBracketsString {
    //规律，一个字符肯定是和i + 1 * n位置的字符闭合
    public static void main(String[] args) {
        String s = "()[]{}";
        boolean valid = isValid("()");
        System.out.println(valid);
    }

    //todo improve, test case passed 84/91
    public static boolean isValid(String s) {
        if (s == null || s.trim().isEmpty()) {
            return true;
        }
        Stack<Character> characters = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c: chars) {
            if (c == '(') {
                characters.push(')');
            }else if (c == '{') {
                characters.push('}');
            } else if (c == '[') {
                characters.push(']');
            } else if (characters.isEmpty() || characters.pop() != c){
                return false;
            }
        }
        return characters.isEmpty();
    }


}
