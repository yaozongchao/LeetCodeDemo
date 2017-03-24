package com.company;

import com.sun.org.apache.bcel.internal.generic.SWAP;
import sun.rmi.runtime.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static String strClassName = Main.class.getName();
    public static Logger mLogger = Logger.getLogger(strClassName);

    public static void main(String[] args) {
	// write your code here
//        SortSolution sortSolution = new SortSolution();

//        int a[] = {8, 2, 5, 3, 9, 6};
//        sortSolution.bubbleSort(a);
//        sortSolution.selectSort(a);
//        sortSolution.insertSort(a);
//        int[] result = new int[a.length];
//        sortSolution.mergeSort(a, 0, a.length-1, result);
//        sortSolution.quickSort(a, 0, a.length-1);
        //        logger.info("" + result);
        runListNodeDemo();
    }

    private static void runListNodeDemo() {
        ListNodeSolution solution = new ListNodeSolution();
        int a[] = {8, 2, 5, 3, 9, 6};
        ListNode head = solution.createListNode(a);
//        ListNode reversedHead = solution.reverseListNode(head);
//        ListNode result = solution.getListNode(head, 4);
//        ListNode result = solution.getMiddleListNode(head);
        List<Integer> resultArray = new ArrayList<Integer>();
        solution.printReverseListNode(head, resultArray);
    }
}
