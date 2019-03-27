package com.caiyunlin;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

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
        ListNode n2 = new ListNode(5);
        n2.next = new ListNode(6);
        n2.next.next = new ListNode(4);

        //常规用例
        ListNode result = addTwoNumbers2(n1, n2);
        System.out.println("Input is " + getListNodeString(n1) + "," + getListNodeString(n2));
        System.out.println("Output is " + getListNodeString(result));

        //l1=[0,1]
        //l2=[0,1,2]   当一个列表比另一个列表长时。
        n1 = new ListNode(0);
        n1.next = new ListNode(1);
        n2 = new ListNode(0);
        n2.next = new ListNode(1);
        n2.next.next = new ListNode(2);
        result = addTwoNumbers2(n1, n2);
        System.out.println("Input is " + getListNodeString(n1) + "," + getListNodeString(n2));
        System.out.println("Output is " + getListNodeString(result));

        //l1=[]
        //l2=[0,1]     当一个列表为空时，即出现空列表。
        n1 = null;
        n2 = new ListNode(0);
        n2.next = new ListNode(1);
        result = addTwoNumbers2(n1, n2);
        System.out.println("Input is " + getListNodeString(n1) + "," + getListNodeString(n2));
        System.out.println("Output is " + getListNodeString(result));

        //l1=[9,9]
        //l2=[1]       求和运算最后可能出现额外的进位，这一点很容易被遗忘
        n1 = new ListNode(9);
        n1.next = new ListNode(9);
        n2 = new ListNode(1);
        result = addTwoNumbers2(n1, n2);
        System.out.println("Input is " + getListNodeString(n1) + "," + getListNodeString(n2));
        System.out.println("Output is " + getListNodeString(result));

    }

    private String getListNodeString(ListNode input) {
        ListNode node = input;
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(node.val);
            if (node.next != null) {
                sb.append(" -> ");
            }
            node = node.next;
        }
        return sb.toString();
    }

    /*
    第一版算法： 能实现初步需求，考虑不周，存在以下问题 1. 数组长度不等， 2. 空列表， 3. 进位两次
    请特别注意以下情况：
        测试用例	 说明
        l1=[0,1]
        l2=[0,1,2]   当一个列表比另一个列表长时。

        l1=[]
        l2=[0,1]     当一个列表为空时，即出现空列表。

        l1=[9,9]
        l2=[1]       求和运算最后可能出现额外的进位，这一点很容易被遗忘
    * */
    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode currentNode1 = l1;
        ListNode currentNode2 = l2;
        int sum = (currentNode1.val + currentNode2.val);
        int carryOver = sum >= 10 ? 1 : 0;
        sum = sum >= 10 ? sum % 10 : sum;
        ListNode listNode3 = new ListNode(sum);
        ListNode currentNode3 = listNode3;
        while (currentNode1.next != null && currentNode2.next != null) {
            currentNode1 = currentNode1.next;
            currentNode2 = currentNode2.next;
            sum = (currentNode1.val + currentNode2.val) + carryOver;
            carryOver = sum >= 10 ? 1 : 0;
            sum = sum >= 10 ? sum % 10 : sum;
            currentNode3.next = new ListNode(sum);
            currentNode3 = currentNode3.next;
        }
        return listNode3;
    }

    //根据测试用例改进版, 参考了线上版本
    private ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0); //假的头
        ListNode p = l1, q = l2, currentNode = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = x + y + carry;
            carry = sum / 10; //取得进位数
            currentNode.next = new ListNode(sum % 10);
            currentNode = currentNode.next;
            p = p != null ? p.next : null;
            q = q != null ? q.next : null;
        }
        if (carry > 0) { //进位
            currentNode.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}