package main.problems.heycoach.assignments;

import static main.problems.heycoach.assignments.P2388_BubbleSort.printArr;

public class P2389_MergeSort {
    public static void main(String[] args) {
        int[] ip = {10, 8, 9, 1, 7, 6, 4};
        mergeSort(ip, 0, ip.length - 1);

        System.out.println("=========== Sorted Array ===========");
        printArr(ip);
    }

    private static void mergeSort(int[] ar, int start, int end) {
        if (end-start > 1) {
            int mid = (start + end) / 2;
            mergeSort(ar, start, mid);
            mergeSort(ar, mid + 1, end);
            mergeSortedArrays(ar, start, mid, end);

            System.out.print("start: " + start + ", mid: " + mid + ", end: " + end + ", Ar: ");
            printArr(ar);
        }
    }

    private static void mergeSortedArrays(int[] ar, int start, int mid, int end) {
        int len = end - start + 1;
        int[] tempSortedArray = new int[len];

        System.out.print("Start - tempSortedArray: ");
        printArr(tempSortedArray);

        int i = start, j = mid + 1, index = 0;
        while (index < len && (i<= mid || j<= end)) {
            if (ar[i] > ar[j]) {
                tempSortedArray[index++] = ar[j++];
            }
            else {
                tempSortedArray[index++] = ar[i++];
            }

            System.out.print("i = " + i + ", j = " + j + ", index: " + index + ", Ar: ");
            printArr(tempSortedArray);
        }

        for (index = 0; index < len; index++) {
            ar[start + index] = tempSortedArray[index];
        }

        System.out.print("Final - tempSortedArray: ");
        printArr(tempSortedArray);
    }
}
