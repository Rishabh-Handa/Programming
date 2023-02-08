package patterns.linkedlist;

import patterns.ListNode;

/**
 *
 */
public class ReverseAlternativeKElements {

    public static void main(String[] args) {
        ListNode head = ListNode.getListNode();
        ListNode lastNode = head;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
        ListNode seven = new ListNode(7);
        ListNode six = new ListNode(6, seven);
        lastNode.next = six;
        ListNode result = reverseAlternativeLNodes(head, 2);
        ListNode.printListNode(result);

        head = ListNode.getListNode();
        lastNode = head;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
        ListNode eight = new ListNode(8);
        seven = new ListNode(7, eight);
        six = new ListNode(6, seven);
        lastNode.next = six;
        ListNode.printListNode(head);
        result = reverseAlternativeLNodes(head, 3);
        ListNode.printListNode(result);
    }

    private static ListNode reverseAlternativeLNodes(ListNode head, int k) {
        if(k <= 1 || head == null) {
            return head;
        }

        ListNode previousHead = null;
        ListNode curr = head;
        ListNode nextHead = head;

        int count;
        boolean flag = true;
        while (nextHead != null) {
            count = 0;
            ListNode toBeSetAsPrevHead = nextHead;
            curr = nextHead;
            if(!flag){
                flag = true;
                for (int i=0; i<k && nextHead != null; i++){
                    nextHead = nextHead.next;
                    previousHead = previousHead.next;
                }
                continue;
            }
            while(nextHead != null && count < k) {
                count++;
                nextHead = nextHead.next;
            }
            ListNode prev = nextHead;
            while(curr != nextHead) {
                ListNode nextNode = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextNode;
            }

            if(previousHead != null) {
                previousHead.next = prev;
            } else {
                head = prev;
            }

            previousHead = toBeSetAsPrevHead;
            flag = false;
        }

        return head;
    }
}
