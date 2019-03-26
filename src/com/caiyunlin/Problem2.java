package com.caiyunlin;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Problem2 implements Problem {
    /*
    给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
    如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
    您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
    示例：
    输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
    输出：7 -> 0 -> 8
    原因：342 + 465 = 807
    */

    @Override
    public void Run() {
        //first
        ListNode n1 = new ListNode(2);
        n1.next = new ListNode(4);
        n1.next.next = new ListNode(3);
        //second
        ListNode n2 = new ListNode(7);
        n2.next = new ListNode(0);
        n2.next.next = new ListNode(8);

        ListNode result = addTwoNumbers(n1, n2);

        System.out.println("Result is " + result.val + " -> " + result.next.val + "->" + result.next.next.val);

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        throw new NotImplementedException();
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}