package patterns.linkedlist;

import patterns.ListNode;

import static patterns.twopointers.FindLinkedListPalindrome.reverseLinkedList;

public class ReverseLinkedList {

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

        ListNode result = reverseLinkedList(one);

        while(result != null) {
            System.out.print(result + ",");
            result = result.next;
        }
    }
}
