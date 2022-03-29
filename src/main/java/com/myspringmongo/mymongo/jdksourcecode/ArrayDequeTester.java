package com.myspringmongo.mymongo.jdksourcecode;

import java.util.ArrayDeque;

public class ArrayDequeTester {

    public static void main(String[] args) {
        ArrayDeque<String> deque = new ArrayDeque<>();

        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");
        deque.addFirst("e");

        deque.addLast("x");
        deque.addLast("y");
        deque.addLast("z");

        System.out.println(deque.pollLast());
        System.out.println(deque.pollLast());
        System.out.println(deque.pollLast());
        System.out.println(deque.pollLast());
        System.out.println(deque.pollLast());
        System.out.println(deque.pollLast());
        System.out.println(deque.pollLast());
    }

    //双端链表， 内置head & tail 双指针, head = 0, tail = length -1
    // AddFirst 方法: head = (head - 1) & (length - 1), head从尾部开始往前移动
    // PollFirst 方法: 通过head指针取元素element[head], 同时进行位运算 head = (head + 1) & (length - 1),
    //当head到达尾部时，再加1就会置0，从而可以获取到AddLast添加进来的元素

    //AddLast: tail = (tail + 1) & (elements.length - 1), 从头部开始添加元素，tail指针后移
    //PollLast: element[tail], int t = (tail - 1) & (elements.length - 1), 到达顶头部时，再-1进行位运算会进入到队列尾部
}
