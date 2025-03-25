package main.problems.leetcode;

public class LinkedListKReversal {
    public class Node {
        int value;
        Node next;
        public Node(int value) {
            this.value = value;
        }
        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getNext() {
            return next;
        }
    }

    public Node actualHead = new Node(1);
    int lengthOfList;

    public LinkedListKReversal(int length) {
        lengthOfList = length;

        Node prevHead = actualHead;
        for (int i = 2; i <= length; i++) {
            Node a = new Node(i);
            prevHead.setNext(a);
            prevHead = a;
        }
    }

    public void printList(Node head) {
        Node current = head;
        do {
            System.out.print(current.value + " -> ");
            current = current.getNext();
        }
        while(current.getNext() != null);

        System.out.println(current.value);
    }

    public void reverseInGroupsOfK(int k) {
        int remainingNodes = lengthOfList;

        Node currHead = actualHead;
        Node prevListTail = null;
        Node newSubListHead;
        while (remainingNodes >= k) {
            newSubListHead = reverseLinkedListAndGetNewHeadWhileMaintainingPreviousLink(prevListTail, currHead, k);

            // for updating new overall list head (only to happen in 1st iteration
            if (prevListTail == null) {
                actualHead = newSubListHead;
            }

            // for next iteration
            prevListTail = currHead;
            currHead = currHead.getNext();
            remainingNodes -= k;
        }

        System.out.println();
        System.out.println("\t\tOPERATION DONE");
        printList(actualHead);
    }

    /**
     * After the reversal of k-elements,
     * \t the initial head would be the new tail of the reversed part
     * \t the new head would be current element at the end of while loop
     *
     * @param prevOfList
     * @param head
     * @param k
     * @return newHead of the sublist after k reversals
     */
    private Node reverseLinkedListAndGetNewHeadWhileMaintainingPreviousLink(Node prevOfList, Node head, int k) {
        if (k == 1) return head;

        Node updatedHead = head;
        Node previous = head;
        Node current = previous.getNext();
        Node next = current.getNext();

        int iteration = 1;
        while (current !=null && iteration < k) {
            // link previous to next
            previous.setNext(next);

            // lint current to previous
            current.setNext(updatedHead);

            System.out.print("    ===> " + (prevOfList == null ? "" : ("( " + prevOfList.value+"-> ) ")));
            printList(current);

            iteration++;

            // update new head
            updatedHead = current;
            // point to new first element of list
            if (prevOfList != null)
                prevOfList.setNext(updatedHead);

            // for next iteration
            current = next;
            if (next != null)
                next = next.getNext();
        }

        return updatedHead;
    }

}
