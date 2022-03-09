package com.myspringmongo.mymongo.algorithm.leetcode;
//实现 strStr() 函数。
//
//        给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
//
//         
//
//        说明：
//
//        当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
//
//        对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。

public class StrStr {

    public static void main(String[] args) {
        strStr("hello", "ll");

    }


    public static int strStr(String haystack, String needle) {
        if (haystack.equals(needle) || haystack.contains(needle)) {
            return 0;
        }
        char[] chars = haystack.toCharArray();
        char[] chars1 = needle.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            boolean equals = false;
            for (int j = 0; j < chars1.length; j++) {
                if (i + j >= chars.length) {
                    break;
                }
                if (chars[i + j] != chars1[j]) {
                    break;
                }

                if (j == chars1.length - 1) {
                    equals = true;
                }
            }

            if (equals) {
                return i;
            }
        }
        return -1;
    }
}
