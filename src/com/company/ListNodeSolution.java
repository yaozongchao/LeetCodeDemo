package com.company;

/**
 * Created by yzc on 17/3/23.
 */
public class ListNodeSolution {

    // 知识点
    // 1.逆转可以考虑堆栈

    public ListNode createListNode(int[] valArray) {
        ListNode head = new ListNode(0);
        head.next = null;
        ListNode curNode = head;

        for (int i = 0; i < valArray.length; i++) {
            ListNode node = new ListNode(valArray[i]);
            node.next = null;
            curNode.next = node;
            curNode = curNode.next;
        }

        return head.next;
    }

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

    ///https://leetcode.com/problems/odd-even-linked-list/?tab=Description
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode oddCurNode = head;
        ListNode evenStartNode = head.next;
        ListNode evenCurNode = head.next;
        while (evenCurNode != null && evenCurNode.next != null) {
            oddCurNode.next = oddCurNode.next.next;
            evenCurNode.next = evenCurNode.next.next;
            oddCurNode = oddCurNode.next;
            evenCurNode = evenCurNode.next;
        }
        oddCurNode.next = evenStartNode;
        return head;
    }


    ///https://leetcode.com/problems/merge-two-sorted-lists/?tab=Description
    public ListNode mergeList(ListNode head1, ListNode head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;
        ListNode newHead = new ListNode(0);
        newHead.next = null;
        ListNode curNode = newHead;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                curNode.next = head1;
                head1 = head1.next;
            }
            else {
                curNode.next = head2;
                head2 = head2.next;
            }
            curNode = curNode.next;
        }

        while (head1 != null) {
            curNode.next = head1;
            head1 = head1.next;
            curNode = curNode.next;
        }

        while (head2 != null) {
            curNode.next = head2;
            head2 = head2.next;
            curNode = curNode.next;
        }

        curNode.next = null;
        return newHead.next;
    }

    ///https://leetcode.com/problems/merge-k-sorted-lists/?tab=Description 递归
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length <= 0) return null;
        if (lists.length == 1) return lists[0];
        int mid = lists.length/2;
        ListNode[] left = new ListNode[mid];
        ListNode[] right = new ListNode[lists.length - mid];
        for (int i = 0; i < lists.length; i++) {
            if (i < mid) {
                left[i] = lists[i];
            }
            else {
                right[i-mid] = lists[i];
            }
        }
        return mergeList(mergeKLists(left), mergeKLists(right));
    }

}
