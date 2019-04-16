package com.caiyunlin;

public class Problem19 implements Problem {
    /*
    给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
    示例：
    给定一个链表: 1->2->3->4->5, 和 n = 2.
    当删除了倒数第二个节点后，链表变为 1->2->3->5.
    说明：
    给定的 n 保证是有效的。
    进阶：
    你能尝试使用一趟扫描实现吗？
    */
    @Override
    public void Run() {
        ListNode head = new ListNode(1);
        ListNode currentNode = head;
        currentNode.next = new ListNode(2);
        currentNode = currentNode.next;
        currentNode.next = new ListNode(3);
        currentNode = currentNode.next;
        currentNode.next = new ListNode(4);
        currentNode = currentNode.next;
        currentNode.next = new ListNode(5);

        ListNode result = removeNthFromEnd2(head, 2);
        PrintNode(result);
    }

    //注意官方解法： 可以使用Dummy节点放在 head 前面，可以用来应付第一个节点被删除的特殊情况
    //https://leetcode-cn.com/articles/remove-nth-node-from-end-of-list/

    //解题思路：得出总数，得出正序然后跳过对应节点(需要循环两次链表)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int totalNodes = head == null ? 0 : 1;
        ListNode currentNode = head;
        while (currentNode.next != null) {
            totalNodes += 1;
            currentNode = currentNode.next;
        }
        int skipNode = totalNodes - n;
        if (skipNode == 0) { //跳过第0个
            head = head.next;
        } else {
            currentNode = head;
            while (skipNode > 0) {
                skipNode--;
                if (skipNode == 0) {
                    currentNode.next = currentNode.next.next;
                } else {
                    currentNode = currentNode.next;
                }
            }
        }
        return head;
    }


    //解题思路2： 使用双指针，即第一个指针先走N步，然后两个指针同时移动，当第一个指针为空的时候，第二个指针即为需要跳过的节点
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode first = head, second = head;
        int totalNodes = head == null ? 0 : 1;
        int index = n;
        while (first.next != null) {
            totalNodes += 1;
            first = first.next;
            index--;
            if (index < 0) {
                second = second.next;
            }
        }
        if (totalNodes == n) { //跳过第0个
            head = head.next;
        } else {
            second.next = second.next.next;
        }
        return head;
    }

    private void PrintNode(ListNode head) {
        if (head != null) {
            while (head.next != null) {
                System.out.print(head.val);
                System.out.print(" -> ");
                head = head.next;
            }
            System.out.println(head.val);
        }
    }
}
/**
 * Definition for singly-linked list. already defined in Problem2
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

