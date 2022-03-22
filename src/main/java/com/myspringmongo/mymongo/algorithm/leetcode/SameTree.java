package com.myspringmongo.mymongo.algorithm.leetcode;


//执行结果：
//        通过
//        显示详情
//        添加备注
//
//        执行用时：
//        0 ms
//        , 在所有 Java 提交中击败了
//        100.00%
//        的用户
//        内存消耗：
//        39.1 MB
//        , 在所有 Java 提交中击败了
//        12.86%
//        的用户
//        通过测试用例：
//        60 / 60
// 一遍过的感觉真好！！！！
public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return compare(p, q);
    }

    private boolean compare(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (!equals(p, q)) {
            return false;
        }
        return compare(p.left, q.left) && compare(p.right, q.right);
    }

    private boolean equals(TreeNode p, TreeNode q) {
        if (p != null) {
            if (q == null) {
                return false;
            }
            return p.val == q.val;
        }

        if (q != null) {
            if (p == null) {
                return false;
            }
            return p.val == q.val;
        }

        return p == null && q == null;
    }

    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
