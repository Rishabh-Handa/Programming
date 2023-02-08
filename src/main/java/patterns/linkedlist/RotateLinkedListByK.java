package patterns.linkedlist;

import patterns.ListNode;

/**
 * Rotate a LinkedList (medium) #
 * Given the head of a Singly LinkedList and a number ‘k’, rotate the LinkedList to the right by ‘k’ nodes.
 */
public class RotateLinkedListByK {
    public static void main(String[] args) {
        ListNode head = ListNode.getListNode();
        ListNode result = rotateKNodes(head, 2);
        ListNode.printListNode(result);

        head = ListNode.getListNode();
        result = rotateKNodes(head, 3);
        ListNode.printListNode(result);

        head = ListNode.getListNode();
        result = rotateKNodes(head, 8);
        ListNode.printListNode(result);
    }

    private static ListNode rotateKNodes(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;

        ListNode findLength = head;
        int l = 0;
        while (findLength != null) {
            findLength = findLength.next;
            l++;
        }
        k = k % l;
        for(int i=0; i<k; i++) {
            fast = fast.next;
        }

        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        ListNode result = slow.next;
        slow.next = null;
        fast.next = head;

        return result;
    }
}
