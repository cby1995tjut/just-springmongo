package com.myspringmongo.mymongo.algorithm.leetcode;
//编写一个函数来查找字符串数组中的最长公共前缀。
//
//如果不存在公共前缀，返回空字符串 ""。
public class LongestCommonPrefix {

    //最长前缀 取第一个字符串 与后面所有的字符挨个对比
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int length = strs[0].length();
        for (int i = 0; i < length; i++) {
            char temp = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                //超出最短字符串的长度或者不相等时,得到最长前缀
                if (i >= strs[j].length() || strs[j].charAt(i) != temp) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0];
    }
}
