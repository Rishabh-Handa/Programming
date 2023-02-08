package patterns.twopointers;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;


/**
 * Problem Statement #
 * return if singly linked list has cycle
 * Given the head of a Singly LinkedList that contains a cycle, write a function to find the starting node of the cycle.
 */
public class FastAndSlowPointer {
    static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }
    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = three;

        System.out.println(detectCycle(one));
        System.out.println("---Find cycle start-----");
        System.out.println(findCycleHead(one));

        six.next = null;

        System.out.println(detectCycle(one));

        System.out.println("---Find cycle start-----");
        System.out.println(findCycleHead(one));
    }

    private static boolean detectCycle(Node one) {
        if(one == null) {
            return false;
        }
        Node fast = one;
        Node slow = one;

        do {
            fast = fast.next;
            if(fast != null) {
                fast = fast.next;
            }
            slow = slow.next;


        } while(fast != null && !fast.equals(slow));

        return fast != null && fast.equals(slow);
    }

    static Node findCycleHead(Node head) {
        Set<Node> nodes = new HashSet<>();
        Node node = head;
        while(node != null) {
            if(nodes.contains(node)) {
                return node;
            }
            nodes.add(node);
            node = node.next;
        }
        return new Node(-1);
    }
}
