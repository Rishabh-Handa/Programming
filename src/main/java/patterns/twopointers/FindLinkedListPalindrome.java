package patterns.twopointers;


import patterns.ListNode;

/**
 * Given the head of a singly linked list, return true if it is a palindrome.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,2,1]
 * Output: true
 */
public class FindLinkedListPalindrome {
    public boolean isPalindrome(ListNode head) {
        ListNode middle = middleNode(head);
        ListNode reversedHead = reverseLinkedList(middle);

        ListNode p1 = head;
        ListNode p2 = reversedHead;

        while(p1 != null && p2 != null) {
            if(p1.val != p2.val) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        return true;
    }

    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;

    }

    public static ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
