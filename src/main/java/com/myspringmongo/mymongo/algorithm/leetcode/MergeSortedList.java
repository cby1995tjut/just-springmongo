package com.myspringmongo.mymongo.algorithm.leetcode;

import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class MergeSortedList {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(1);
        listNode1.next = new ListNode(2);
        listNode1.next.next = new ListNode(4);

        listNode2.next = new ListNode(2);
        listNode2.next.next = new ListNode(4);

        ListNode listNode = mergeTwoLists(listNode1, listNode2);
        System.out.println(listNode);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(1);
        ListNode first = result;
        while (list1 != null && list2 !=null) {
            if (list1.val <= list2.val) {
                result.next = new ListNode(list1.val);
                list1 = list1.next;

            } else {
                result.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            result = result.next;

        }
        ListNode node = list1 == null ? list2 : list1;
        append(result, node);
        return first.next;
    }

    private static void append(ListNode result, ListNode listNode) {
        result.next = listNode;
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
