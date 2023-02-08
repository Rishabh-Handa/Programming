package patterns.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, connect each node with its level order successor.
 * The last node of each level should point to the first node of the next level.
 */
public class ConnectAllLevelOrder {
    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };


    public static Node connectLevels(Node root) {
        if(root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);

        Node prevNode = null;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i < size; i++) {
                Node currNode = queue.poll();
                if(prevNode != null) {
                    prevNode.next = currNode;
                }

                prevNode = currNode;

                if(currNode.left != null) {
                    queue.offer(currNode.left);
                }

                if(currNode.right != null) {
                    queue.offer(currNode.right);
                }
            }
        }

        return root;
    }
}
