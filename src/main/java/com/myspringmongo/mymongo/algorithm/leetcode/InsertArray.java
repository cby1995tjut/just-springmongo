package com.myspringmongo.mymongo.algorithm.leetcode;

//        3、查找整数 输入：一个有序数组array，一个整数n 输出：如果n在array里，
//        // 输出n的位置；如果n不在array中输出n可以插入的位置，插入后的数组仍然有序


//问题3
public class InsertArray {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2};
        int i = 4;
        int[] result = insertToArray(i, array);
        for (int j = 0; j < result.length; j++) {
            System.out.println(result[j]);
        }
        System.out.println("------------------");
        int[] array1 = new int[]{1, 2};
        int i1 = 0;
        int[] result1 = insertToArray(i1, array1);

        for (int j = 0; j < result1.length; j++) {
            System.out.println(result1[j]);
        }
        System.out.println("------------------");
        int[] array2 = new int[]{1, 2, 3, 4};
        int i2 = 2;
        int[] result2 = insertToArray(i2, array2);

        for (int j = 0; j < result2.length; j++) {
            System.out.println(result2[j]);
        }

        System.out.println("------------------");
        int[] array3 = new int[]{1, 3, 4};
        int i3 = 2;
        int[] result3 = insertToArray(i3, array3);

        for (int j = 0; j < result3.length; j++) {
            System.out.println(result3[j]);
        }
    }


    private static int[] insertToArray(int i, int[] array) {
        int insertIndex = getIndexWithBinarySearch(i, 0, array.length - 1, array);
        int[] newArray = new int[array.length + 1];
        if (insertIndex == array.length || insertIndex == 0) {
            newArray[insertIndex] = i;
        }

        int plusOne = 0;
        if (insertIndex == 0) {
            plusOne ++;
        }

        for (int j = 0; j < array.length; j++) {
            newArray[j + plusOne] = array[j];

            if (j == insertIndex && plusOne == 0) {
                newArray[j + plusOne] = i;
                j--;
                plusOne ++;
            }
        }
        return newArray;
    }

    //二分查找
    private static int getIndexWithBinarySearch(int i, int min, int max, int[] array) {
        if (i >= array[array.length - 1]) {
            return array.length;
        }

        if (i <= array[0]) {
            return 0;
        }

        if ((max - min) <= 1) {
            return max;
        }

        if (array == null || array.length == 0) {
            return 0;
        }

        int mid = min + (max - min) / 2;

        if ( i < array[mid]) {
            return getIndexWithBinarySearch(i, min, mid, array);
        }
        if (i > array[mid]) {

            return getIndexWithBinarySearch(i, mid, max, array);
        }

        return mid;

    }

}
