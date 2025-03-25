package main.problems;

import main.problems.leetcode.LinkedListKReversal;

public class Test {
    public static void main(String[] args) {
        LinkedListKReversal listKReversal = new LinkedListKReversal(10);
        int k = 6;
        LinkedListKReversal.Node initalHead = listKReversal.actualHead;

        System.out.println("\t\tBEFORE OPERATION");
        listKReversal.printList(initalHead);
        System.out.println();

        listKReversal.reverseInGroupsOfK(k);
        System.out.println();
    }
}

