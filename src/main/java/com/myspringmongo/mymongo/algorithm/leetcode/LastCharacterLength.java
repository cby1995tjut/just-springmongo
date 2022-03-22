package com.myspringmongo.mymongo.algorithm.leetcode;


//给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
//
//        单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
public class LastCharacterLength {

    public static void main(String[] args) {
        int i = lengthOfLastWord("luffy is still joyboy");

    }

//    public static int lengthOfLastWord(String s) {
//        char[] chars = s.toCharArray();
//        StringBuffer tmp = new StringBuffer();
//        String result = "";
//        for (char c: chars) {
//            if (Character.isLetter(c)) {
//                tmp.append(c);
//            } else {
//                if (!"".equals(tmp.toString())) {
//                    result = tmp.toString();
//                }
//                tmp = new StringBuffer();
//            }
//        }
//        if (!"".equals(tmp.toString())) {
//            result = tmp.toString();
//        }
//        return result.length();
//    }

    //反向遍历, 执行用时：
    //0 ms
    //, 在所有 Java 提交中击败了
    //100.00%
    //的用户
    //内存消耗：
    //39.6 MB
    //, 在所有 Java 提交中击败了
    //23.54%
    //的用户

    public static int lengthOfLastWord(String s) {
        char[] chars = s.toCharArray();
        int length = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (Character.isLetter(chars[i])) {
                length++;
            } else {
                if (length != 0) {
                    return length;
                }
            }
        }
        return length;
    }
}
