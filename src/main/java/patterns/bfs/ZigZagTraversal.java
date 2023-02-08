package patterns.bfs;

import patterns.TreeNode;

import java.util.*;

public class ZigZagTraversal {

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);
        TreeNode eight = new TreeNode(8);
        TreeNode nine = new TreeNode(9);
        one.left = two; one.right = three;
        two.left = four; two.right = five;
        three.left = six; three.right = seven;
        five.left = eight;
        six.right = nine;

        System.out.println(zigZag(one));

    }

    private static List<List<Integer>> zigZag(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);

        int level = 0;

        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> levelNodes = new ArrayList<>();
            if(level % 2 == 0) {
                for(int i=0; i<size; i++) {
                    TreeNode currNode = deque.pollFirst();
                    levelNodes.add(currNode.val);

                    if(currNode.left != null) {
                        deque.addLast(currNode.left);
                    }

                    if(currNode.right != null) {
                        deque.addLast(currNode.right);
                    }
                }
            } else {
                for(int i=size; i>0; i--) {
                    TreeNode currNode = deque.pollLast();
                    levelNodes.add(currNode.val);

                    if(currNode.right != null) {
                        deque.addFirst(currNode.right);
                    }

                    if(currNode.left != null) {
                        deque.addFirst(currNode.left);
                    }
                }
            }
            result.add(levelNodes);
            level++;
        }

        return result;
    }
}
