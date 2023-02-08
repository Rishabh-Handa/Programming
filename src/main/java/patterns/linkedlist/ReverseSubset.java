package patterns.linkedlist;

import patterns.ListNode;

import static patterns.ListNode.getListNode;

public class ReverseSubset {
    public static void main(String[] args) {

        ListNode result = reverseSubset(getListNode(), 2, 4);

        while(result != null) {
            System.out.print(result + ",");
            result = result.next;
        }
        System.out.println();
        result = reverseSubset(getListNode(), 4, 5);

        while(result != null) {
            System.out.print(result + ",");
            result = result.next;
        }

        System.out.println();
        result = reverseSubset(getListNode(), 1, 4);

        while(result != null) {
            System.out.print(result + ",");
            result = result.next;
        }
    }

    private static ListNode reverseSubset(ListNode head, int p, int q) {
        ListNode prevHead = null;

        ListNode currHead = head;


        for (int i = 1; i < p; i++) {
            prevHead = currHead;
            currHead = currHead.next;
        }

        if (currHead.next == null) {
            return head;
        }

        for (int i = 1; i <= (q - p + 1); i++) {
            currHead = currHead.next;
        }

        ListNode nextHead = currHead;
        currHead = prevHead == null ? head : prevHead.next;

        ListNode prev = nextHead;
        while (currHead != nextHead) {
            ListNode temp = currHead.next;
            currHead.next = prev;
            prev = currHead;
            currHead = temp;
        }

        if (prevHead != null) {
            prevHead.next = prev;
        } else {
            return prev;
        }

        return head;
    }
}
