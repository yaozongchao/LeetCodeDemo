package com.company;

/**
 * Created by yzc on 17/3/23.
 */
public class ListNodeSolution {

    // 知识点
    // 1.逆转可以考虑堆栈


    // 206. Reverse Linked List
    // https://leetcode.com/problems/reverse-linked-list/#/description
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || m > n) return null;

        ListNode newHead = head;
        for(int i = 0; i<m-1; i++) head = head.next;

        ListNode start = head; // a pointer to the beginning of a sub-list that will be reversed
        ListNode then = start.next; // a pointer to a node that will be reversed

        // 1 - 2 -3 - 4 - 5 ; m=2; n =4 ---> pre = 1, start = 2, then = 3
        // dummy-> 1 -> 2 -> 3 -> 4 -> 5

        for(int i=0; i<n-m; i++)
        {
            ListNode next = then;
            head.next = start;
            newHead = head;
            start = next;
        }

        // first reversing : dummy->1 - 3 - 2 - 4 - 5; pre = 1, start = 2, then = 4
        // second reversing: dummy->1 - 4 - 3 - 2 - 5; pre = 1, start = 2, then = 5 (finish)

        return newHead;
    }

}
