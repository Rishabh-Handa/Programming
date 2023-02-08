package epam;

/**
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [4,5,1,2,3]
 */

// edge cases: k > length of List
public class RotateLinkedList {

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        Node head = one;

        printNodes(head);

        Node newHead = rotateNodes(head, 11);

        System.out.println();

        printNodes(newHead);

    }

    private static Node rotateNodes(Node head, int k) {
        if(head == null) {
            return null;
        }
        int length = findLength(head);

        if(length == 1) {
            return head;
        }

        k = k % length;

        Node headerNode = head;

        //1
        Node slow = head;
        for(int i=0; i<k; i++) {
            head = head.next;
        }

        //3
        Node fast = head;

        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        Node newHead = slow.next;
        slow.next = null;
        fast.next = headerNode;

        return newHead;
    }


    static void printNodes(Node head) {
        while(head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
    }

    static int findLength(Node head) {
        int length = 0;
        while(head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

}
