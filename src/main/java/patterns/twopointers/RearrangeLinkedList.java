package patterns.twopointers;

import patterns.ListNode;

/**
 * Rearrange a LinkedList (medium) #
 * Given the head of a Singly LinkedList, write a method to modify the LinkedList such that
 * the nodes from the second half of the LinkedList are inserted alternately to the nodes from
 * the first half in reverse order. So if the LinkedList
 *
 * has nodes 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null,
 *
 * your method should return 1 -> 6 -> 2 -> 5 -> 3 -> 4 -> null.
 */
public class RearrangeLinkedList {
    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        //five.next = six;

        ListNode result = rearrangeLinkedList(one);

        while(result != null) {
            System.out.print(result + ",");
            result = result.next;
        }
    }

    private static ListNode rearrangeLinkedList(ListNode head) {
        ListNode middle = getMiddleElement(head);
        ListNode lastElement = reverseAfterMiddle(middle);

        ListNode p1 = head;
        ListNode p3 = lastElement;

        while(p3.next != null) {
            ListNode p2 = p1.next;
            ListNode p4 = p3.next;

            p1.next = p3;
            p3.next = p2;

            p1 = p2;
            p3 = p4;
        }

        return head;
    }

    private static ListNode reverseAfterMiddle(ListNode middle) {
        ListNode prev = null;
        ListNode curr = middle;

        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    static ListNode getMiddleElement(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
