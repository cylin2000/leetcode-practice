package com.caiyunlin;

public class Problem21 implements Problem {
    /*
    合并两个有序链表
    示例：
        输入：1->2->4, 1->3->4
        输出：1->1->2->3->4->4
    */

    @Override
    public void Run() {
        ListNode l1 = new ListNode(1);
        ListNode currentNode = l1;
        currentNode.next = new ListNode(2);
        currentNode = currentNode.next;
        currentNode.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        currentNode = l2;
        currentNode.next = new ListNode(3);
        currentNode = currentNode.next;
        currentNode.next = new ListNode(4);

        ListNode l3 = mergeTwoLists(l1, l2);
        PrintNode(l3);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode currentNode = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                currentNode.next = l1;
                l1 = l1.next;
            } else {
                currentNode.next = l2;
                l2 = l2.next;
            }
            currentNode = currentNode.next;
        }
        if (l1 != null) {
            currentNode.next = l1;
        }
        if (l2 != null) {
            currentNode.next = l2;
        }

        return dummy.next;
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
