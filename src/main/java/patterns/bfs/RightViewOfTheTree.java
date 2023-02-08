package patterns.bfs;

import patterns.TreeNode;

import java.util.*;

/**
 * Given a binary tree, return an array containing nodes in its right view.
 * The right view of a binary tree is the set of nodes visible when the tree is seen from the right side.
 */
public class RightViewOfTheTree {
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

        System.out.println(rightView(one));
    }

    private static List<Integer> rightView(TreeNode root) {
        if(root == null) {
            return Collections.emptyList();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i=0; i<size; i++) {
                TreeNode currNode = queue.poll();
                if(i+1 == size) {
                    result.add(currNode.val);
                }

                if(currNode.left != null) {
                    queue.offer(currNode.left);
                }

                if(currNode.right != null) {
                    queue.offer(currNode.right);
                }
            }
        }

        return result;
    }
}
