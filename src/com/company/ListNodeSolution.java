package com.company;

import java.util.List;

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

    // 求单链表中节点的个数
    public int getNodeCount(ListNode head) {
        ListNode current = head;
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    // 将单链表翻转
    // 206. Reverse Linked List
    // https://leetcode.com/problems/reverse-linked-list/#/description
    public ListNode reverseListNode(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode current = head;
        ListNode newHead = null;
        while (current != null) {
            ListNode tmp = current;
            current = current.next;
            tmp.next = newHead;
            newHead = tmp;
        }
        return newHead;
    }

    // 取单链表的倒数第K个节点
    public ListNode getListNode(ListNode head, int k) {
        if (head == null || k <= 0) return null;
        ListNode firstCurrent = head;
        ListNode secondCurrent = head;

        while (firstCurrent != null && k > 0) {
            firstCurrent = firstCurrent.next;
            k--;
        }
        if (k > 0) {
            return null;
        }

        while (firstCurrent != null) {
            firstCurrent = firstCurrent.next;
            secondCurrent = secondCurrent.next;
        }
        return secondCurrent;
    }

    // 取链表的中间结点
    public ListNode getMiddleListNode(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode aheadCurrent = head;
        ListNode behindCurrent = head;
        while (aheadCurrent != null && aheadCurrent.next != null) {
            aheadCurrent = aheadCurrent.next.next;
            behindCurrent = behindCurrent.next;
        }
        return behindCurrent;
    }

    // 判断单链表是否有环
    public boolean hasCircle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode fastCurNode = head;
        ListNode slowCurNode = head;
        while (fastCurNode != null && fastCurNode.next != null) {
            fastCurNode = fastCurNode.next.next;
            slowCurNode = slowCurNode.next;
            if (fastCurNode == slowCurNode) return true;
        }
        return false;
    }

    public void printReverseListNode(ListNode head, List<Integer> resultArray) {
        if (head == null) return; // 递归退出
        printReverseListNode(head.next, resultArray);
        resultArray.add(head.val);
    }

    public ListNode mergeSortedNode2(ListNode head1, ListNode head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;
        ListNode newHeadNode = null;
        if (head1.val < head2.val) {
            newHeadNode = head1;
            newHeadNode.next = mergeSortedNode2(head1.next, head2);
        }
        else {
            newHeadNode = head2;
            newHeadNode.next = mergeSortedNode2(head1, head2.next);
        }
        return newHeadNode;
    }

    // 合并有序链表，循环的方式
    public ListNode mergeSortedNode(ListNode head1, ListNode head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;
        ListNode newHead = null;

        // 先安上第一个节点，确定返回值
        if (head1.val < head2.val) {
            newHead = head1;
            newHead.next = null;
            head1 = head1.next;
        }
        else {
            newHead = head2;
            newHead.next = null;
            head2 = head2.next;
        }

        ListNode newCurrent = newHead;

        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                newCurrent.next = head1;
                newCurrent = newCurrent.next;
                head1 = head1.next;
                newCurrent.next = null;
            }
            else {
                newCurrent.next = head2;
                newCurrent = newCurrent.next;
                head2 = head2.next;
                newCurrent.next = null;
            }
        }

        while (head1 != null) {
            newCurrent.next = head1;
            newCurrent = newCurrent.next;
            head1 = head1.next;
            newCurrent.next = null;
        }

        while (head2 != null) {
            newCurrent.next = head2;
            newCurrent = newCurrent.next;
            head2 = head2.next;
            newCurrent.next = null;
        }
        return newHead;
    }

    //在O(1)的时间复杂度内，删除链表结点
    ListNode deleteNode(ListNode head, ListNode node) {
        if (head == null || node == null) return null;
        if (head == node) {
            head = null;
            node = null;
            return null;
        }
        ListNode curNode = head;
        // 如果要删除的结点是尾结点
        if (node.next == null) {
            while (curNode != null) {
                if (curNode.next.val == node.val) {
                    curNode.next = null;
                }
                curNode = curNode.next;
            }
        }
        else {
            ListNode nextNode = node.next;
            node.val = nextNode.val;
            node.next = nextNode.next;
            nextNode = null;
        }
        return head;
    }

    // 翻转链表，分析见剑指offer第112页
    public ListNode reverseNodes(ListNode head) {
        ListNode newHeadNode = null;
        ListNode curNode = head;
        ListNode preNode = null;
        while (curNode != null) {
            ListNode nextNode = curNode.next;
            if (nextNode == null) {
                newHeadNode = curNode;
            }
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }
        return newHeadNode;
    }

    // 递归实现单链表反转，http://www.cnblogs.com/kubixuesheng/p/4394509.html可参考其对递归的分析
    public ListNode reverseNodes2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode nextNode = head.next;
        head.next = null;
        ListNode reverseRest = reverseNodes2(nextNode);
        nextNode.next = head;
        return reverseRest;
    }

}
